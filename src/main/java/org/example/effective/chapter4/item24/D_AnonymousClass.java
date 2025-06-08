package org.example.effective.chapter4.item24;

/**
 * 익명 클래스
 * - 클래스 이름없이 1회성 객체 생성
 * - 인터페이스나 추상클래스 구현체로 많이 사용
 */
public class D_AnonymousClass {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class running");
            }
        };

        task.run();
    }
}
