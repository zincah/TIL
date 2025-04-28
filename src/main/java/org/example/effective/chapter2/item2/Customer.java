package org.example.effective.chapter2.item2;

import java.util.Objects;

public class Customer extends User{
    public enum Level {BRONZE, SILVER, GOLD, DIAMOND};
    private Level level;
    private final String customerId;

    public static class Builder extends User.Builder<Builder>{
        private Level level;
        private final String customerId;

        public Builder(Level level, String customerId){
            this.level = Objects.requireNonNull(level);
            this.customerId = Objects.requireNonNull(customerId);
        }

        public Builder level(Level level){
            this.level = level;
            return this;
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public Builder toBuilder(){
        return new Customer.Builder(this.level, this.customerId)
                .from(this);
    }

    private Customer(Builder builder){
        super(builder);
        level = builder.level;
        customerId = builder.customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "level=" + level +
                ", customerId='" + customerId + '\'' +
                ", authorities=" + authorities +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
