package com.workshop.naming.customers;

import com.workshop.naming.Customer;

public class Employee extends Customer {
    @Override
    public double calculateTax(double amount) {
        double newAmount = amount-(amount*0.15);

        if(amount > 1000) {
            newAmount = newAmount - (amount * 0.05);
        }

        return newAmount;
    }
}
