package org.example.effective.chapter6.item39;

public class Sample {

    @Test
    public static void m1(){} // 성공
    public static void m2(){}
    @Test
    public static void m3(){ // 실패
        throw new RuntimeException("실패");
    }
    public static void m4(){}
    @Test
    public void m5(){} // 잘못 사용한 예
    public static void m6(){}
    @Test
    public static void m7(){ // 실패
        throw new RuntimeException("실패");
    }
    public static void m8(){}

    public static void main(String[] args) throws Exception {
        String[] arr = { Sample.class.getName() };
        RunTests.main(arr);
    }

}
