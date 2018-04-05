package com.sklep.controllers;

import com.sklep.services.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiscountController {

    private final IDiscountService discountService;

    @Autowired
    public DiscountController(IDiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping(value = "discount/get/{id}")
    @ResponseBody
    public double getDiscount(@PathVariable("id") int id) {
        return discountService.getDiscount(id);
    }
}
