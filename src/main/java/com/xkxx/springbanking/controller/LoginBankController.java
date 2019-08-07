package com.xkxx.springbanking.controller;

import com.xkxx.springbanking.commands.LoginCommand;
import com.xkxx.springbanking.entity.Customer;
import com.xkxx.springbanking.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class LoginBankController {
    @Autowired
    private AuthenticationService authenticationService;


    protected ModelAndView onSubmit(Object command) throws Exception {
        LoginCommand loginCommand = (LoginCommand) command;
        Customer customer = authenticationService.authenticate(loginCommand);
        ModelAndView view = new ModelAndView();
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("accountdetail", customer);
        view.addAllObjects(model);
        view.setViewName("onSubmit");
        return view;
    }
}
