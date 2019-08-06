package com.xkxx.springbanking.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class OrderItem {
    private Logger log = LoggerFactory.getLogger(getClass());
    /**
     * Composite Key class for Entity Bean: OrderItem
     * <p>
     * Key consists of essentially two foreign key relations, but is mapped as foreign keys.
     */
    public static class PK implements Serializable {
        private static final long serialVersionUID = 5954772684349231393L;
        private Logger log = LoggerFactory.getLogger(getClass());

        public String inventoryID;
        public String order_orderID;

        public PK(String inventoryID, String order_orderID) {
            this.inventoryID = inventoryID;
            this.order_orderID = order_orderID;
        }

        public PK() {
        }

        /**
         * Returns true if both keys are equal.
         */
        public boolean equals(java.lang.Object otherKey) {
            if (otherKey instanceof PK) {
                PK o = (PK) otherKey;
                return ((this.inventoryID.equals(o.inventoryID)) && (this.order_orderID.equals(o.order_orderID)));
            }
            return false;
        }

        /**
         * Returns the hash code for the key.
         */
        public int hashCode(){
            log.debug("OrderItem.PK.hashCode() inventoryID=" + inventoryID + "=");
            log.debug("OrderItem.PK.hashCode() orderID=" + order_orderID + "=");
            return (inventoryID.hashCode() + order_orderID.hashCode());
        }
    }

    private OrderItem.PK id;
    private String name;
    private String pkginfo;
    private float price;
    private float cost;
    private int category;
    private int quantity;
    private String sellDate;
    private String inventoryId;
    private Inventory inventory;
    private Order order;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPkginfo() {
        return pkginfo;
    }

    public void setPkginfo(String pkginfo) {
        this.pkginfo = pkginfo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public OrderItem() {
    }

    public OrderItem(Inventory inv) {
        log.debug("OrderItem(inv) - id = " + inv.getInventoryId());
        setInventoryId(inv.getInventoryId());
        inventory = inv;
        name = inv.getName();
        pkginfo = inv.getPkginfo();
        price = inv.getPrice();
        cost = inv.getCost();
        category = inv.getCategory();
    }

    public OrderItem(Order order, String orderID, Inventory inv, java.lang.String name, java.lang.String pkginfo,
                     float price, float cost, int quantity, int category, java.lang.String sellDate) {
        log.debug("OrderItem(etc.)");
        inventory = inv;
        setInventoryId(inv.getInventoryId());
        setName(name);
        setPkginfo(pkginfo);
        setPrice(price);
        setCost(cost);
        setQuantity(quantity);
        setCategory(category);
        setSellDate(sellDate);
        setOrder(order);
        id = new OrderItem.PK(inv.getInventoryId(), order.getOrderID());
    }

    /*
     * updates the primary key field with the composite orderId+inventoryId
     */
    public void updatePK() {
        id = new OrderItem.PK(inventoryId, order.getOrderID());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inv) {
        this.inventory = inv;
    }

    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order for this item Also updates the sellDate
     *
     * @param order
     */
    public void setOrder(Order order) {
        this.order = order;
        this.sellDate = order.getSellDate();
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
    /**
     * Same as getInventoryId. Added for compatability with ShoppingCartItem when used by the Client
     * XJB sample
     *
     * @return String ID of the inventory item
     */
    public String getID() {
        return inventoryId;
    }

    /**
     * Same as setInventoryId. Added for compatability with ShoppingCartItem when used by the Client
     * XJB sample
     *
     */
    public void setID(String id) {
        inventoryId = id;
    }
}
