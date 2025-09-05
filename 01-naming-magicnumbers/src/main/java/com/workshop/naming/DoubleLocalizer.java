package com.workshop.naming;

import java.util.Locale;

public class DoubleLocalizer {
    public static String localize(String locale, double amount) {
        return switch(locale.toLowerCase()) {
            case "tr" -> String.format(new Locale("tr","TR"), "%.2f TL", amount);
            default -> String.format(Locale.US, "$%.2f", amount);
        };
    }
}