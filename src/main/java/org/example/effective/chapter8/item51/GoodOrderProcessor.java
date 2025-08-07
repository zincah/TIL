package org.example.effective.chapter8.item51;

public class GoodOrderProcessor {

    public void processOrder(OrderRequest request) {
        System.out.printf("[Builder 방식] Processing order for user: %s%n", request.getUserId());
        System.out.printf("Item: %s (%d units)%n", request.getItemId(), request.getQuantity());
        System.out.printf("Shipping to: %s via %s%n", request.getShippingAddress(), request.getPaymentMethod());
    }
}