package com.workshop.naming;

import com.workshop.naming.customers.Employee;
import com.workshop.naming.customers.Regular;
import com.workshop.naming.customers.Vip;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceCalculatorTest {
    @Test void regular_small_tr(){
        Customer customer = new Regular();
        String s = new InvoiceCalculator().calc(customer, 40, "tr");
        assertTrue(s.contains("TL"));
    }
    @Test void vip_medium_us(){
        Customer customer = new Vip();
        String s = new InvoiceCalculator().calc(customer, 600, "en");
        assertTrue(s.startsWith("$"));
    }
    @Test void employee_large(){
        Customer customer = new Employee();
        String s = new InvoiceCalculator().calc(customer, 1200, "tr");
        assertTrue(s.contains("TL"));
    }
}
