package com.xkxx.springbanking.bean;

import com.xkxx.springbanking.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 5598817214065204731L;
    private Logger log = LoggerFactory.getLogger(getClass());

    private ArrayList<Inventory> items = new ArrayList<Inventory>();

    /**
     * Add an item to the cart.
     *
     * @param new_item
     *            Item to add to the cart.
     */
    public void addItem(Inventory new_item) {
        boolean added = false;
        // If the same item is already in the cart, just increase the quantity.
        for (Inventory old_item : items) {
            if (old_item.getID().equals(new_item.getID())) {
                old_item.setQuantity(old_item.getQuantity() + new_item.getQuantity());
                added = true;
                break;
            }
        }
        // Add this item to shopping cart, if it is a brand new item.
        if (!added)
            items.add(new_item);
    }

    /**
     * Remove an item from the cart.
     *
     * @param item
     *            Item to remove from cart.
     */
    public void removeItem(Inventory item) {
        for (Inventory i : items) {
            if (item.equals(i)) {
                items.remove(i);
                break;
            }
        }
    }

    /**
     * Remove all items from the cart.
     */
    public void removeAllItems() {
        items = new ArrayList<Inventory>();
    }

    /**
     * Remove zero quantity items.
     */
    public void removeZeroQuantityItems() {
        ArrayList<Inventory> newItems = new ArrayList<Inventory>();

        for (Inventory i : items) {
            if (i.getQuantity() > 0) {
                newItems.add(i);
            }
        }

        items = newItems;
    }

    /**
     * Get the items in the shopping cart.
     *
     * @return A Collection of ShoppingCartItems.
     */
    public ArrayList<Inventory> getItems() {
        return items;
    }

    /**
     * Set the items in the shopping cart.
     *
     * @param items
     *            A Vector of ShoppingCartItem's.
     */
    public void setItems(Collection<Inventory> items) {
        this.items = new ArrayList<Inventory>(items);
    }

    /**
     * Get the contents of the shopping cart.
     *
     * @return The contents of the shopping cart. / public ShoppingCartContents getCartContents() {
     *         ShoppingCartContents cartContents = new ShoppingCartContents(); // Fill it with data.
     *         for (int i = 0; i < items.size(); i++) { cartContents.addItem((ShoppingCartItem)
     *         items.get(i)); } return cartContents; }
     */

    /**
     * Create a shopping cart.
     *
     * @param cartContents
     *            Contents to populate cart with. / public void setCartContents(ShoppingCartContents
     *            cartContents) { items = new ArrayList<ShoppingCartItem>(); int qty; String
     *            inventoryID; ShoppingCartItem si; Inventory inv; for (int i = 0; i <
     *            cartContents.size(); i++) { inventoryID = cartContents.getInventoryID(i); qty =
     *            cartContents.getQuantity(inventoryID); inv = em.find(Inventory.class,
     *            inventoryID); // clone so we can use Qty as qty to purchase, not inventory in
     *            stock si = new ShoppingCartItem(inv); si.setQuantity(qty); addItem(si); } }
     */
//    public void setCartContents(ShoppingCartContents cartContents) {
    /**
     * Get the cost of all items in the shopping cart.
     *
     * @return The total cost of all items in the shopping cart.
     */
    public float getSubtotalCost() {
        float f = 0.0F;

        for (Inventory item : items) {
            f += item.getPrice() * (float) item.getQuantity();
        }
        return f;
    }

    /**
     * Method checkInventory. Check the inventory level of a store item. Order additional inventory
     * when necessary.
     *
     * @param si
     *            - Store item
     */
    public void checkInventory(Inventory si) {
        log.debug("ShoppingCart.checkInventory() - checking Inventory quantity of item: " + si.getID());
        Inventory inv = getInventoryItem(si.getID());

        /**
         * Decrease the quantity of this inventory item.
         *
         * @param quantity
         *            The number to decrease the inventory by.
         * @return The number of inventory items removed.
         */
        int quantity = si.getQuantity();
        int minimumItems = inv.getMinThreshold();

        int amountToOrder = 0;
        log.debug("ShoppingCartBean:checkInventory() - Decreasing inventory item " + inv.getInventoryId());
        int quantityNotFilled = 0;
        if (inv.getQuantity() < 1) {
            quantityNotFilled = quantity;
        } else if (inv.getQuantity() < quantity) {
            quantityNotFilled = quantity - inv.getQuantity();
        }

        // When quantity becomes < 0, this will be to determine the
        // quantity of unfilled orders due to insufficient stock.
        inv.setQuantity(inv.getQuantity() - quantity);

        // Check to see if more inventory needs to be ordered from the supplier
        // based on a set minimum Threshold
        if (inv.getQuantity() < minimumItems) {
            // Calculate the amount of stock to order from the supplier
            // to get the inventory up to the maximum.
            amountToOrder = quantityNotFilled;
            backOrder(inv, amountToOrder);
        }

    }

    /**
     * Create an order with contents of a shopping cart.
     *
     * @param customerID
     *            customer's ID
     * @param billName
     *            billing name
     * @param billAddr1
     *            billing address line 1
     * @param billAddr2
     *            billing address line 2
     * @param billCity
     *            billing address city
     * @param billState
     *            billing address state
     * @param billZip
     *            billing address zip code
     * @param billPhone
     *            billing phone
     * @param shipName
     *            shippng name
     * @param shipAddr1
     *            shippng address line 1
     * @param shipAddr2
     *            shippng address line 2
     * @param shipCity
     *            shippng address city
     * @param shipState
     *            shippng address state
     * @param shipZip
     *            shippng address zip code
     * @param shipPhone
     *            shippng phone
     * @param creditCard
     *            credit card
     * @param ccNum
     *            credit card number
     * @param ccExpireMonth
     *            credit card expiration month
     * @param ccExpireYear
     *            credit card expiration year
     * @param cardHolder
     *            credit card holder name
     * @param shippingMethod
     *            int of shipping method used
     * @param items
     *            vector of StoreItems ordered
     * @return OrderInfo
     */
    public Order createOrder(String customerID,
                             String billName,
                             String billAddr1,
                             String billAddr2,
                             String billCity,
                             String billState,
                             String billZip,
                             String billPhone,
                             String shipName,
                             String shipAddr1,
                             String shipAddr2,
                             String shipCity,
                             String shipState,
                             String shipZip,
                             String shipPhone,
                             String creditCard,
                             String ccNum,
                             String ccExpireMonth,
                             String ccExpireYear,
                             String cardHolder,
                             int shippingMethod,
                             Collection<Inventory> items) {
        Order order = null;
        log.debug("ShoppingCartBean.createOrder:  Creating Order");
        Collection<OrderItem> orderitems = new ArrayList<OrderItem>();
        for (Inventory si : items) {
            Inventory inv = null;
            //TODO
//            inv = em.find(Inventory.class, si.getID());
            OrderItem oi = new OrderItem(inv);
            oi.setQuantity(si.getQuantity());
            orderitems.add(oi);
        }
        Customer c = null;
//        c = em.find(Customer.class, customerID);
        order = new Order(c, billName, billAddr1, billAddr2, billCity, billState, billZip, billPhone, shipName,
                shipAddr1, shipAddr2, shipCity, shipState, shipZip, shipPhone, creditCard, ccNum, ccExpireMonth,
                ccExpireYear, cardHolder, shippingMethod, orderitems);
//        em.persist(order);
//        em.flush();
        // store the order items
        for (OrderItem o : orderitems) {
            o.setOrder(order);
            o.updatePK();
//            em.persist(o);
        }
//        em.flush();

        return order;
    }

    public int getSize() {
        return getItems().size();
    }

    /*
     * Get the inventory item.
     *
     * @param id of inventory item.
     *
     * @return an inventory bean.
     */
    private Inventory getInventoryItem(String inventoryID) {
        Inventory inv = null;
//        inv = em.find(Inventory.class, inventoryID);
        return inv;
    }

    /*
     * Create a BackOrder of this inventory item.
     *
     * @param quantity The number of the inventory item to be backordered
     */
    private void backOrder(Inventory inv, int amountToOrder) {
        BackOrder b = null;
//        b = em.find(BackOrder.class, inv.getInventoryId());
        if (b == null) {
            // create a new backorder if none exists
            BackOrder newBO = new BackOrder(inv, amountToOrder);
//            em.persist(newBO);
//            em.flush();
            inv.setBackOrder(newBO);
        } else {
            // update the backorder with the new quantity
            int quantity = b.getQuantity();
            quantity += amountToOrder;
//            em.lock(b, LockModeType.WRITE);
//            em.refresh(b);
            b.setQuantity(quantity);
//            em.flush();
            inv.setBackOrder(b);
        }
    }
}
