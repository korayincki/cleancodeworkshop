package com.workshop.godclass;

import com.workshop.godclass.service.*;

public class OrderProcessor {
    private final DiscountService discountService = new DiscountService();
    private final ShippingService shippingService = new ShippingService();
    private final TaxService taxService = new TaxService();
    private final PersistanceService persistanceService = new PersistanceService();
    private final NotificationService notificationService = new NotificationService();
    private final PaymentService paymentService = new PaymentService();

    public boolean process(Order order){
        double total = 0;
        for(Order.OrderLine line : order.lines()){
            total += line.qty() * line.unitPrice();
        }

        total = discountService.calculateDiscount(total);

        total = shippingService.calculateShipping(total);

        total = taxService.calculateTax(total);

        boolean isPersisted = persistanceService.save(order, total);

        if(!isPersisted){
            return false;
        }

        notificationService.notify(order, total);

        paymentService.processPayment(total);

        return true;
    }
}
