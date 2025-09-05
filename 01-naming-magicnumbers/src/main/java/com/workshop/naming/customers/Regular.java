package com.workshop.naming.customers;

import com.workshop.naming.Customer;

public class Regular extends Customer {

    @Override
    public double calculateTax(double amount) {
        if(amount > 500) {
            amount = amount - (amount * 0.03);
        }

        return amount;
    }
}
