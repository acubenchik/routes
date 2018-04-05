package com.sklep.inventory.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("checkout-service")
public interface CheckoutClient {

    @RequestMapping(method = RequestMethod.GET, value = "/checkout")
    void checkout();
}
