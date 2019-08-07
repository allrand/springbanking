package com.xkxx.springbanking.controller;

import com.xkxx.springbanking.bean.CustomerMgr;
import com.xkxx.springbanking.bean.ShoppingCart;
import com.xkxx.springbanking.entity.Customer;
import com.xkxx.springbanking.entity.LoginInfo;
import com.xkxx.springbanking.entity.OrderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

@Controller
public class Account implements Serializable {
    private static final long serialVersionUID = 7980541836039145794L;
    private static final String ACTION_ACCOUNT = "account";
    private static final String ACTION_CHECKOUT_FINAL = "checkout_final";
    private static final String ACTION_LOGIN = "login";
    private static final String ACTION_ORDERDONE = "orderdone";
    private static final String ACTION_ORDERINFO = "orderinfo";
    private static final String ACTION_PROMO = "promo";
    private static final String ACTION_REGISTER = "register";
    private boolean checkingOut;
    private int orderNum = 1;
    private boolean register;
    private boolean updating;
    private String lastOrderNum;

    private Customer customer;
    private Customer newCustomer;
    private LoginInfo loginInfo;
    private OrderInfo orderInfo;

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerMgr login;

    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        log.debug("/login get");
        return Account.ACTION_LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String performAccount(){
        log.debug("/login post");
        if (customer == null || loginInfo == null){
            checkingOut = false;
            loginInfo = new LoginInfo();
            register = false;
            updating = true;
            loginInfo.setMessage("You must log in first.");
            return Account.ACTION_LOGIN;
        }else {
            return Account.ACTION_ACCOUNT;
        }
    }

    public String performAccountUpdate() {
        if (register) {
            customer = login.createCustomer(loginInfo.getEmail(), loginInfo.getPassword(), newCustomer
                    .getFirstName(), newCustomer.getLastName(), newCustomer.getAddr1(), newCustomer
                    .getAddr2(), newCustomer.getAddrCity(), newCustomer
                    .getAddrState(), newCustomer.getAddrZip(), newCustomer.getPhone());
            register = false;
        }

        else {
            customer = login.updateUser(customer.getCustomerId(), customer.getFirstName(), customer
                    .getLastName(), customer.getAddr1(), customer.getAddr2(), customer
                    .getAddrCity(), customer.getAddrState(), customer.getAddrZip(), customer.getPhone());
        }

        return Account.ACTION_PROMO;
    }

    public String performCheckoutFinal() {
        return Account.ACTION_CHECKOUT_FINAL;
    }

    public String performCompleteCheckout() {


        //shoppingCart.setCartContents (new ShoppingCartContents());
        shoppingCart.removeAllItems();

        return Account.ACTION_ORDERDONE;
    }

    public String performLogin() {
        checkingOut = false;
        loginInfo = new LoginInfo();
        register = false;
        updating = false;

        loginInfo.setMessage("");

        return Account.ACTION_LOGIN;
    }

    public String performLoginComplete() {
        String message;

        // Attempt to log in the user.

        message = login.verifyUserAndPassword(loginInfo.getEmail(), loginInfo.getPassword());

        if (message != null) {
            // Error, so go back to the login page.

            loginInfo.setMessage(message);

            return Account.ACTION_LOGIN;
        }

        // Otherwise, no error, so continue to the correct page.

        customer = login.getCustomer(loginInfo.getEmail());

        if (isCheckingOut()) {
            return performOrderInfo();
        }

        if (isUpdating()) {
            return performAccount();
        }

        return Account.ACTION_PROMO;
    }
    public String performOrderInfo() {
        if (customer == null) {
            checkingOut = true;
            loginInfo = new LoginInfo();
            register = false;
            updating = false;

            loginInfo.setMessage("You must log in first.");

            return Account.ACTION_LOGIN;
        }

        else {
            if (orderInfo == null) {
                orderInfo = new OrderInfo(customer.getFirstName() + " " + customer.getLastName(), customer.getAddr1(),
                        customer.getAddr2(), customer.getAddrCity(), customer.getAddrState(), customer.getAddrZip(),
                        customer.getPhone(), "", "", "", "", "", "", "", 0, "" + (orderNum++));
            }

            return Account.ACTION_ORDERINFO;
        }
    }

    public String performRegister() {
        loginInfo = new LoginInfo();
        newCustomer = new Customer("", "", "", "", "", "", "", "", "", "");
        register = true;
        updating = false;

        return Account.ACTION_REGISTER;
    }

    public Customer getCustomer() {
        return (isRegister() ? newCustomer : customer);
    }

    public String getLastOrderNum() {
        return lastOrderNum;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public boolean isCheckingOut() {
        return checkingOut;
    }

    public boolean isRegister() {
        return register;
    }

    public boolean isUpdating() {
        return updating;
    }
}
