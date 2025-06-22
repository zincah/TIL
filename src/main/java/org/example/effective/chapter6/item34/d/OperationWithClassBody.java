package org.example.effective.chapter6.item34.d;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum OperationWithClassBody {
    PLUS("+") {
        public double calculate(double a, double b) {
            return a + b;
        }
    },
    MINUS("-") {
        public double calculate(double a, double b) {
            return a - b;
        }
    },
    TIMES("*") {
        public double calculate(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        public double calculate(double a, double b) {
            return a / b;
        }
    };

    private final String symbol;

    OperationWithClassBody(String symbol) {
        this.symbol = symbol;
    }

    //toString을 override하여 PLUS가 아닌 + 반환
    @Override
    public String toString() {
        return symbol;
    }

    private static final Map<String, OperationWithClassBody> map = Stream.of(values()).collect(toMap(Object::toString, e->e));

    public static Optional<OperationWithClassBody> fromString(String symbol) {
        return Optional.ofNullable(map.get(symbol));
    }


    public abstract double calculate(double a, double b);
}
