package org.example.effective.chapter8.item51;

public class OrderRequestBuilder {
    private String userId;
    private String itemId;
    private int quantity;
    private String shippingAddress;
    private String paymentMethod;

    public OrderRequestBuilder userId(String userId) {
        this.userId = userId; return this;
    }

    public OrderRequestBuilder itemId(String itemId) {
        this.itemId = itemId; return this;
    }

    public OrderRequestBuilder quantity(int quantity) {
        this.quantity = quantity; return this;
    }

    public OrderRequestBuilder shippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress; return this;
    }

    public OrderRequestBuilder paymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod; return this;
    }

    public OrderRequest build() {
        return new OrderRequest(userId, itemId, quantity, shippingAddress, paymentMethod);
    }
}
