package com.workshop.godclass.service;

public class DiscountService {
    public double calculateDiscount(double total) {
        if(total > 500) total = total * 0.95;
        if(total > 1000) total = total * 0.90;

        return total;
    }
}
