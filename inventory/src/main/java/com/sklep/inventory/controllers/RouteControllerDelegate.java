package com.sklep.inventory.controllers;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "sorry")
    public ResponseEntity checkout(){
        this.checkoutClient.checkout();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity sorry(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
