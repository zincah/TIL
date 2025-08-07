package org.example.effective.chapter8.item51;

public class OrderRequest {
    private final String userId;
    private final String itemId;
    private final int quantity;
    private final String shippingAddress;
    private final String paymentMethod;

    public OrderRequest(String userId, String itemId, int quantity,
                        String shippingAddress, String paymentMethod) {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    public String getUserId() { return userId; }
    public String getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public String getShippingAddress() { return shippingAddress; }
    public String getPaymentMethod() { return paymentMethod; }
}
