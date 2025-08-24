package org.example.effective.chapter9.item63;

/**
 * 문자열 연결은 느리니 주의
 */
public class Main {



    public static void main(String[] args) {
        String result = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result += i; // 매번 새로운 문자열 객체 생성
        }
        System.out.println(System.currentTimeMillis() - startTime +"m/s");


        long startTime2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(i); // 같은 StringBuilder 객체에 추가
        }
        System.out.println(System.currentTimeMillis() - startTime2 +"m/s");
    }
}
