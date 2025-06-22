package org.example.effective.chapter6.item34.d;


//상수마다 동작이 다른 enum
public enum UnprettyOperation {
    PLUS, MINUS, MULTIPLY, DIVIDE;

    //연산 수행
    public double calculate(double a, double b) {
        //switch문은 사용한 분기처리..
        //새로운 상수가 추가될때 구현하지 않으면 에러 발생
        switch (this) {
            case PLUS: return a + b;
            case MINUS: return a - b;
            case MULTIPLY: return a * b;
            case DIVIDE: return a / b;
        }
        throw new AssertionError("unknown Operation");
    }
}
