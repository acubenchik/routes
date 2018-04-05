package com.sklep.checkout.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CheckoutService {

    void checkout(List<Long> ids);
}

