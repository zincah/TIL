package org.example.effective.chapter6.item34.d;

/**
 * 추상메소드를 사용하여 더 나은 상수별 다르게 동작하는 코드 구현 방식
 * 상수별 메서드 구현 이라고 함 (constant-specific method implementation)
 */
public enum PrettyOperation {
    PLUS {public double calculate(double x, double y){return x + y;}},
    MINUS {public double calculate(double x, double y){return x - y;}},
    TIMES {public double calculate(double x, double y){return x * y;}},
    DIV {public double calculate(double x, double y){return x / y;}};


    //calculate이 추상 메서드이기 때문에, 새로운 상수가 추가될때 구현하지 않으면 에러 발생
    public abstract double calculate(double x, double y);
}
