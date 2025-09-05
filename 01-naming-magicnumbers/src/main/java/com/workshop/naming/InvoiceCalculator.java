package com.workshop.naming;

public class InvoiceCalculator {
    public String calc(Customer customer, double amount, String locale){
        double tax = customer.calculateTax(amount);
        double postTax = customer.addShipping(tax);

        return DoubleLocalizer.localize(locale, postTax);
    }
}
