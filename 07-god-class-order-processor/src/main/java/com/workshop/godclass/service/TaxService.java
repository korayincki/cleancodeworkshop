package com.workshop.godclass.service;

public class TaxService {
    public double calculateTax(double total) {
        total = total * 1.18;
        return total;
    }
}
