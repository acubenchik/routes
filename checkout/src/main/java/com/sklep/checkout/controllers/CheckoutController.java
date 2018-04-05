package com.sklep.checkout.controllers;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CheckoutController {

    @RequestMapping(method = RequestMethod.GET, value = "checkout")
    public void checkout() {
        System.out.println("HERE");
    }
}
