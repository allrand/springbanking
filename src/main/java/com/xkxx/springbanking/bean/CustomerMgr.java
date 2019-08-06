package com.xkxx.springbanking.bean;

import com.xkxx.springbanking.dao.mapper.CustomerMapper;
import com.xkxx.springbanking.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Service
public class CustomerMgr implements Serializable {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * Create a new user.
     *
     * @param customerID The new customer ID.
     * @param password   The password for the customer ID.
     * @param firstName  First name.
     * @param lastName   Last name.
     * @param addr1      Address line 1.
     * @param addr2      Address line 2.
     * @param addrCity   City address information.
     * @param addrState  State address information.
     * @param addrZip    Zip code address information.
     * @param phone      User's phone number.
     * @return Customer
     */
    public Customer createCustomer(String customerID,
                                   String password,
                                   String firstName,
                                   String lastName,
                                   String addr1,
                                   String addr2,
                                   String addrCity,
                                   String addrState,
                                   String addrZip,
                                   String phone) {
        Customer c = new Customer(customerID, password, firstName, lastName, addr1, addr2, addrCity, addrState, addrZip,
                phone);
        int i = customerMapper.insert(c);
        if (i > 0)
            return c;
        else
            return null;
    }

    public int createCustomer(Customer customer) {
        int i = customerMapper.insertSelective(customer);
        return i;
    }

    /**
     * Retrieve an existing user.
     *
     * @param customerID The customer ID.
     * @return Customer
     */
    public Customer getCustomer(String customerID) {
        Customer c = null;
        c = customerMapper.selectByPrimaryKey(customerID);
        log.debug("", c);
        return c;
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = customerMapper.selectAll();
        log.info("customers: {}", customers);
        return customers;
    }
    /**
     * Update an existing user.
     *
     * @param customerID The customer ID.
     * @param firstName  First name.
     * @param lastName   Last name.
     * @param addr1      Address line 1.
     * @param addr2      Address line 2.
     * @param addrCity   City address information.
     * @param addrState  State address information.
     * @param addrZip    Zip code address information.
     * @param phone      User's phone number.
     * @return Customer
     */
    public Customer updateUser(String customerID,
                               String firstName,
                               String lastName,
                               String addr1,
                               String addr2,
                               String addrCity,
                               String addrState,
                               String addrZip,
                               String phone) {
        Customer c = null;

        return c;
    }

    /**
     * Verify that the user exists and the password is value.
     *
     * @param customerID The customer ID
     * @param password   The password for the customer ID
     * @return String with a results message.
     */
    public String verifyUserAndPassword(String customerID, String password) {
        // Try to get customer.
        String results = null;
        Customer customer = null;

        // Does customer exist?
        if (customer != null) {
            if (!customer.verifyPassword(password)) // Is password correct?
            {
                results = "\nPassword does not match for : " + customerID;
                log.debug("Password given does not match for userid=" + customerID);
            }
        } else // Customer was not found.
        {
            results = "\nCould not find account for : " + customerID;
            log.debug("customer " + customerID + " NOT found");
        }

        return results;
    }
}
