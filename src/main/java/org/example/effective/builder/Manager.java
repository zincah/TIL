package org.example.effective.builder;

import java.util.Objects;

public class Manager extends User{
    private final String employeeId;

    public static class Builder extends User.Builder<Builder>{
        private final String employeeId;

        public Builder(String employeeId){
            this.employeeId = Objects.requireNonNull(employeeId);
        }

        @Override
        public Manager build() {
            return new Manager(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }


    private Manager(Builder builder) {
        super(builder);
        this.employeeId = builder.employeeId;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeId='" + employeeId + '\'' +
                ", authorities=" + authorities +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
