package org.example.effective.chapter6.item39;

public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1(){ // 성공
        int i=0;
        i=i/i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2(){ // 실패해야한다. 다른 예외가 발생해서
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3(){} // 실패해야한다. 예외가 발생하지 않아서

    public static void main(String[] args) throws Exception {
        String[] arr = { Sample2.class.getName() };
        RunTests.main(arr);
    }
}
