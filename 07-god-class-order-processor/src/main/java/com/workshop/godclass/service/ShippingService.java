package com.workshop.godclass.service;

public class ShippingService {
    public double calculateShipping(double total) {
        if(total < 100) total += 9.99;
        return total;
    }
}
