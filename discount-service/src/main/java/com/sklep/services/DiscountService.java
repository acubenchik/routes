package com.sklep.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class DiscountService implements IDiscountService {

    @Override
    public double getDiscount(int id) {
        return id %3 == 0 ? 0.1 : 0;
    }
}
