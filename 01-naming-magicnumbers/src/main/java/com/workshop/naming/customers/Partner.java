package com.workshop.naming.customers;

import com.workshop.naming.Customer;

public class Partner extends Customer {

    @Override
    public double calculateTax(double amount) {
        double newAmount = amount-(amount*0.10);
        if(amount > 800) {
            newAmount = newAmount-(amount*0.02);
        }

        return newAmount;
    }
}
