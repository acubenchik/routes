package com.sklep.checkout.controllers;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CheckoutController {

    @RequestMapping(method = RequestMethod.GET, value = "checkout")
    @ResponseBody
    public ResponseEntity checkout() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
