package com.workshop.naming;

public abstract class Customer {

    public double addShipping(double amount) {
        double newAmount = amount;
        if(amount < 50) {
            newAmount = amount + 4.99;
        }

        return Math.round(newAmount*100.0)/100.0;
    }

    public abstract double calculateTax(double amount);
}
