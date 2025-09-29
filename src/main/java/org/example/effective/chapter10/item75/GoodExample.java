package org.example.effective.chapter10.item75;

public class GoodExample {
    public static void divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다: a = " + a + ", b = " + b);
        }
        System.out.println("결과: " + (a / b));
    }
}
