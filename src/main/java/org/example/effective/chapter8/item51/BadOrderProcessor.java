package org.example.effective.chapter8.item51;

public class BadOrderProcessor {

    // 너무 많은 매개변수 (5개)
    public void processOrder(String userId, String itemId, int quantity,
                             String shippingAddress, String paymentMethod) {
        System.out.printf("Processing order for user: %s%n", userId);
        System.out.printf("Item: %s (%d units)%n", itemId, quantity);
        System.out.printf("Shipping to: %s via %s%n", shippingAddress, paymentMethod);
    }
}
