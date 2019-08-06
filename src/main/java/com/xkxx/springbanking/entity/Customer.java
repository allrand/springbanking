package com.xkxx.springbanking.entity;

public class Customer {

    private String customerId;
    private String password;
    private String firstName;
    private String lastName;
    private String addr1;
    private String addr2;
    private String addrCity;
    private String addrState;
    private String addrZip;
    private String phone;
    /**
     * Create a new Customer.
     *
     * @param key
     *            CustomerKey
     * @param password
     *            Password used for this customer account.
     * @param firstName
     *            First name of the customer.
     * @param lastName
     *            Last name of the customer
     * @param addr1
     *            Street address of the customer
     * @param addr2
     *            Street address of the customer
     * @param addrCity
     *            City
     * @param addrState
     *            State
     * @param addrZip
     *            Zip code
     * @param phone
     *            Phone number
     */
    public Customer(String key, String password, String firstName, String lastName, String addr1, String addr2,
                    String addrCity, String addrState, String addrZip, String phone) {
        this.setCustomerID(key);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddr1(addr1);
        this.setAddr2(addr2);
        this.setAddrCity(addrCity);
        this.setAddrState(addrState);
        this.setAddrZip(addrZip);
        this.setPhone(phone);
    }
    public Customer(Customer customer) {
        this.setCustomerID(customer.customerId);
        this.setPassword(customer.password);
        this.setFirstName(customer.firstName);
        this.setLastName(customer.lastName);
        this.setAddr1(customer.addr1);
        this.setAddr2(customer.addr2);
        this.setAddrCity(customer.addrCity);
        this.setAddrState(customer.addrState);
        this.setAddrZip(customer.addrZip);
        this.setPhone(customer.phone);
    }
    public Customer() {}
    /**
     * Verify password.
     *
     * @param password
     *            value to be checked.
     * @return True, if password matches one stored.
     */
    public boolean verifyPassword(String password) {
        return this.getPassword().equals(password);
    }
    /**
     * Get the customer's full name.
     *
     * @return String of customer's full name.
     */
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerID(String customerID) {
        this.customerId = customerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrState() {
        return addrState;
    }

    public void setAddrState(String addrState) {
        this.addrState = addrState;
    }

    public String getAddrZip() {
        return addrZip;
    }

    public void setAddrZip(String addrZip) {
        this.addrZip = addrZip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", addr2='" + addr2 + '\'' +
                ", addrCity='" + addrCity + '\'' +
                ", addrState='" + addrState + '\'' +
                ", addrZip='" + addrZip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
