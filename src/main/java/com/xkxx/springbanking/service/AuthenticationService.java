package com.xkxx.springbanking.service;

import com.xkxx.springbanking.bean.CustomerMgr;
import com.xkxx.springbanking.commands.LoginCommand;
import com.xkxx.springbanking.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerMgr customerMgr;

    public AuthenticationService() {
    }

    public Customer authenticate(LoginCommand command) throws Exception {
        //&& command.getUserId().equalsIgnoreCase("admin")
        //&& command.getPassword().equalsIgnoreCase("password")
        if (command.getUserId() != null && command.getPassword() != null) {
            Customer customer = customerMgr.getCustomer(command.getUserId());

            if (customer.verifyPassword(command.getPassword())){
                log.debug("Login success");
                return customer;
            }
            else
                throw new Exception("User id is not autheticated");
        } else {
            throw new Exception("User id or password is null");
        }
    }
}
