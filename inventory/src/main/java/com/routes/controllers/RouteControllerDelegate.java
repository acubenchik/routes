package com.routes.controllers;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RouteControllerDelegate {

    private final CheckoutClient checkoutClient;

    @Autowired
    public RouteControllerDelegate(CheckoutClient checkoutClient) {
        this.checkoutClient = checkoutClient;
    }

    @HystrixCommand(fallbackMethod = "sorry", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10")
    })
    public ResponseEntity checkout(Map<String, String> params) {
        this.checkoutClient.checkout(params);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity sorry(Map<String, String> params) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
