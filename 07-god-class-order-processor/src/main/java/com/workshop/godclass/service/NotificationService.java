package com.workshop.godclass.service;

import com.workshop.godclass.Order;

public class NotificationService {
    public void notify(Order order, double total) {
        System.out.println("Email to "+order.customerEmail()+": your total is "+total);
    }
}
