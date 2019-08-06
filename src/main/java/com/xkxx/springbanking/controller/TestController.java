package com.xkxx.springbanking.controller;

import com.xkxx.springbanking.bean.CustomerMgr;
import com.xkxx.springbanking.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerMgr login;

    @RequestMapping(value = "/info")
    public String info(Model model) {
        log.info("/test/info");
        model.addAttribute("name", "a10 " + new Date());
//        Customer customer = login.getCustomer("123");
//        log.debug("123 customer: {}", customer);

        List<Customer> customers = login.getCustomers();
        model.addAttribute("customers", customers);
        log.debug("{}", customers);

        return "info";
    }

    @RequestMapping(value = "/create")
    public String create(Model model) {
        log.info("test/create");
        Customer customer = new Customer();
        customer.setFirstName("b10");
        customer.setLastName("xx");
        customer.setAddr1("岳麓区");
        customer.setAddr2("企业广场");
        customer.setAddrCity("长沙");
        customer.setAddrState("湖南");
        customer.setAddrZip("412000");
        customer.setPassword("123456");
        customer.setPhone("1234567890123");
        int i = login.createCustomer(customer);
        log.info("{}", i);
        return "create";
    }
}
