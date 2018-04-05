package com.sklep.inventory.controllers;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "discount-service")
public interface DiscountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/discount/get/{id}")
    double getDiscount(@PathVariable("id") int id);

}
