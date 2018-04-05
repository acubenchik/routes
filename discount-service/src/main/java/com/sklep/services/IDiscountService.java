package com.sklep.services;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IDiscountService {

    double getDiscount(int id);
}
