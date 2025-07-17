package org.example.effective.chapter7.item42;

import java.util.function.DoubleBinaryOperator;

public enum OperationWithLamda {

    PLUS("+", (x,y) -> x+y),
    MINUS("-", (x,y) -> x-y),
    TIMES("*", (x,y) -> x*y),
    DIVIDE("/", (x,y) -> x/y);

    private final String symbol;

    // double 타입 인수 2개를 받아서 double 타입 결과를 돌려주는 클래스
    private final DoubleBinaryOperator op;

    OperationWithLamda(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override public String toString(){return symbol;}
    public double apply(double x, double y){
        return op.applyAsDouble(x,y);
    }
}
