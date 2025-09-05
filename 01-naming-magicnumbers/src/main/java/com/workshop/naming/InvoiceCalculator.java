package com.workshop.naming;

import java.util.Locale;

enum CustomerTypes {
    UNKNOWN, // for handle 0
    REGULAR,
    VIP,
    EMPLOYEE,
    PARTNER
}
//1=regular, 2=vip, 3=employee, 4=partner

/**
 * Dirty: cryptic names, magic numbers, mixed concerns, and formatting mixed in.
 */
public class InvoiceCalculator {
    public String calc(int customerType, double amount, String locale) {
        if (customerType == CustomerTypes.VIP.ordinal()) {
            amount *= Constants.VIP_DISCOUNT;
        } else if (customerType == CustomerTypes.EMPLOYEE.ordinal()) {
            amount = employeeTransactions(amount);
        } else if (customerType == CustomerTypes.PARTNER.ordinal()) {
            amount = partnerTransactions(amount);
        } else {
            if (amount > Constants.REGULAR_LIMIT) {
                amount *= Constants.REGULAR_CONDITIONAL_DISCOUNT;
            }
        }
        amount = roundedTotalAmountCalculation(amount);

        return generateLocalAmount(amount, locale);
    }

    private String generateLocalAmount(double amount, String locale) {
        if ("tr".equalsIgnoreCase(locale)) {
            return String.format(new Locale("tr", "TR"), "%.2f TL", amount);
        } else {
            return String.format(Locale.US, "$%.2f", amount);
        }
    }

    private double roundedTotalAmountCalculation(double amount) {
        if (amount < Constants.SHIPPING_LIMIT) {
            amount += Constants.SHIPPING_AMOUNT;
        }
        amount *= Constants.TAX_RATE;
        return Math.round(amount * 100.0) / 100.0;
    }

    private double partnerTransactions(double amount) {
        amount *= Constants.PARTNER_MAIN_DISCOUNT;
        if (amount > Constants.PARTNER_LIMIT) {
            return amount *= Constants.PARTNER_CONDITIONAL_DISCOUNT;
        }
        return amount;
    }

    private double employeeTransactions(double amount) {
        amount *= Constants.EMPLOYEE_MAIN_DISCOUNT;
        if (amount > Constants.EMPLOYEE_LIMIT) {
            return amount *= Constants.EMPLOYEE_CONDITIONAL_DISCOUNT;
        }
        return amount;
    }
}
