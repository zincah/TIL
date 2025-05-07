package org.example.effective.chapter4.item17;

final class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount); // 새로운 객체 반환
    }

    public int getAmount() {
        return amount;
    }
}
