package org.example.effective.chapter10.item75;

public class BadExample {
    public static void divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Invalid input"); // 너무 추상적
        }
        System.out.println("결과: " + (a / b));
    }
}
