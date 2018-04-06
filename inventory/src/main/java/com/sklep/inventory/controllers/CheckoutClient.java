package com.sklep.inventory.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("checkout-service")
public interface CheckoutClient {

    @RequestMapping(method = RequestMethod.GET, value = "/checkout", produces = "application/json")
    @ResponseBody
    ResponseEntity checkout();
}
