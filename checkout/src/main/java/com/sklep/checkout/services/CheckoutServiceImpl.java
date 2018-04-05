package com.sklep.checkout.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CheckoutService checkoutService;

    @Override
    public void checkout(List<Long> ids) {
        checkoutService.checkout(ids);
    }
}
