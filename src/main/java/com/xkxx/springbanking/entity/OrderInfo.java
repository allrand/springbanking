package com.xkxx.springbanking.entity;

import com.xkxx.springbanking.util.Util;

import java.io.Serializable;
import java.util.Calendar;

public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 3003754048594678129L;
    private String orderID;
    private String billName;
    private String billAddr1;
    private String billAddr2;
    private String billCity;
    private String billState;
    private String billZip;
    private String billPhone;
    private String shipName;
    private String shipAddr1;
    private String shipAddr2;
    private String shipCity;
    private String shipState;

    private String shipZip;
    private String shipPhone;
    private int shippingMethod;
    private String cardholderName;
    private String cardName;

    private String cardNum;
    private String cardExpMonth;
    private String cardExpYear;
    private String[] cardExpYears;
    private boolean shipisbill = false;

    private void initLists() {
        int i = Calendar.getInstance().get(1);
        cardExpYears = new String[5];
        for (int j = 0; j < 5; j++)
            cardExpYears[j] = (new Integer(i + j)).toString();
    }

    /**
     * Constructor to create an OrderInfo by passing each field.
     */
    public OrderInfo(String billName, String billAddr1, String billAddr2, String billCity, String billState,
                     String billZip, String billPhone, String shipName, String shipAddr1, String shipAddr2, String shipCity,
                     String shipState, String shipZip, String shipPhone, int shippingMethod, String orderID) {
        this.orderID = orderID;
        this.billName = billName;
        this.billAddr1 = billAddr1;
        this.billAddr2 = billAddr2;
        this.billCity = billCity;
        this.billState = billState;
        this.billZip = billZip;
        this.billPhone = billPhone;
        this.shipName = shipName;
        this.shipAddr1 = shipAddr1;
        this.shipAddr2 = shipAddr2;
        this.shipCity = shipCity;
        this.shipState = shipState;
        this.shipZip = shipZip;
        this.shipPhone = shipPhone;
        this.shippingMethod = shippingMethod;
        initLists();
        cardholderName = "";
        cardNum = "";
    }

    /**
     * Constructor to create an OrderInfo using an Order.
     *
     * @param order
     */
    public OrderInfo(Order order) {
        orderID = order.getOrderID();
        billName = order.getBillName();
        billAddr1 = order.getBillAddr1();
        billAddr2 = order.getBillAddr2();
        billCity = order.getBillCity();
        billState = order.getBillState();
        billZip = order.getBillZip();
        billPhone = order.getBillPhone();
        shipName = order.getShipName();
        shipAddr1 = order.getShipAddr1();
        shipAddr2 = order.getShipAddr2();
        shipCity = order.getShipCity();
        shipState = order.getShipState();
        shipZip = order.getShipZip();
        shipPhone = order.getShipPhone();
        shippingMethod = order.getShippingMethod();
    }

    /**
     * Get the shipping method name.
     */
    public String getShippingMethodName() {
        return getShippingMethods()[shippingMethod];
    }

    /**
     * Set the shipping method by name
     */
    public void setShippingMethodName(String name) {
        String[] methodNames = Util.getShippingMethodStrings();
        for (int i = 0; i < methodNames.length; i++) {
            if (methodNames[i].equals(name))
                shippingMethod = i;
        }
    }

    /**
     * Get shipping methods that are possible.
     *
     * @return String[] of method names
     */
    public String[] getShippingMethods() {
        return Util.getFullShippingMethodStrings();
    }

    public int getShippingMethodCount() {
        return Util.getShippingMethodStrings().length;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillAddr1() {
        return billAddr1;
    }

    public void setBillAddr1(String billAddr1) {
        this.billAddr1 = billAddr1;
    }

    public String getBillAddr2() {
        return billAddr2;
    }

    public void setBillAddr2(String billAddr2) {
        this.billAddr2 = billAddr2;
    }

    public String getBillCity() {
        return billCity;
    }

    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    public String getBillState() {
        return billState;
    }

    public void setBillState(String billState) {
        this.billState = billState;
    }

    public String getBillZip() {
        return billZip;
    }

    public void setBillZip(String billZip) {
        this.billZip = billZip;
    }

    public String getBillPhone() {
        return billPhone;
    }

    public void setBillPhone(String billPhone) {
        this.billPhone = billPhone;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddr1() {
        return shipAddr1;
    }

    public void setShipAddr1(String shipAddr1) {
        this.shipAddr1 = shipAddr1;
    }

    public String getShipAddr2() {
        return shipAddr2;
    }

    public void setShipAddr2(String shipAddr2) {
        this.shipAddr2 = shipAddr2;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public int getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(int shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardExpMonth() {
        return cardExpMonth;
    }

    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    public String getCardExpYear() {
        return cardExpYear;
    }

    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    public String[] getCardExpYears() {
        return cardExpYears;
    }

    public void setCardExpYears(String[] cardExpYears) {
        this.cardExpYears = cardExpYears;
    }

    public boolean isShipisbill() {
        return shipisbill;
    }

    public void setShipisbill(boolean shipisbill) {
        this.shipisbill = shipisbill;
    }
}
