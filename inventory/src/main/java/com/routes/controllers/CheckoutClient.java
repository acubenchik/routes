package com.routes.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient("checkout-service")
public interface CheckoutClient {

    @RequestMapping(method = RequestMethod.POST, value = "/checkout", produces = "application/json")
    @ResponseBody
    ResponseEntity checkout(@RequestBody Map<String, String> params);
}
