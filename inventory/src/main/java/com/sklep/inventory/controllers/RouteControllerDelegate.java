package com.sklep.inventory.controllers;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10")
    })
    public ResponseEntity checkout() {
        this.checkoutClient.checkout();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity sorry() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
