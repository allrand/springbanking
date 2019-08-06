package com.xkxx.springbanking.entity;

import com.xkxx.springbanking.util.Util;

public class BackOrder {
    private String backOrderID;
    private int quantity;
    private String status;
    private long lowDate;
    private long orderDate;
    private String supplierOrderID; // missing table
    private Inventory inventory;
    public BackOrder() {
    }

    public BackOrder(String backOrderID) {
        setBackOrderID(backOrderID);
    }

    public BackOrder(Inventory inventory, int quantity) {
        this.setInventory(inventory);
        this.setQuantity(quantity);
        this.setStatus(Util.STATUS_ORDERSTOCK);
        this.setLowDate(System.currentTimeMillis());
    }


    public String getBackOrderID() {
        return backOrderID;
    }

    public void setBackOrderID(String backOrderID) {
        this.backOrderID = backOrderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLowDate() {
        return lowDate;
    }

    public void setLowDate(long lowDate) {
        this.lowDate = lowDate;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public String getSupplierOrderID() {
        return supplierOrderID;
    }

    public void setSupplierOrderID(String supplierOrderID) {
        this.supplierOrderID = supplierOrderID;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
