package org.example.effective.chapter6.item34.d;

public class Test {
    public static void main(String[] args) {
        double x = 2.0;
        double y = 4.0;
        for(OperationWithClassBody op : OperationWithClassBody.values())
            System.out.printf("%f %s %f = %f%n",x,op,y,op.calculate(x,y));

        System.out.println(OperationWithClassBody.fromString("*"));
        System.out.println(OperationWithClassBody.fromString("$"));

        System.out.println(PrettyOperationWithFromString.fromString("PLUS"));
        System.out.println(PrettyOperationWithFromString.fromString("FLUS"));

    }
}
