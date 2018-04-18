package com.sklep.checkout.controllers;

import com.sklep.checkout.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CheckoutController {

    @RequestMapping(method = RequestMethod.POST, value = "checkout")
    @ResponseBody
    public ResponseEntity checkout(@RequestBody Order order) {
        //SEND EMAIL OR STORE INTO DB HERE
        return ResponseEntity.ok(null);

    }
}
