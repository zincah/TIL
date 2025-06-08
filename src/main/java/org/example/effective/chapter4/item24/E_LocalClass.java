package org.example.effective.chapter4.item24;

/**
 * 지역 클래스
 * - 메서드 또는 블록 내부에 정의되는 클래스
 * - 정의된 브록 내에서만 사용 가능
 */
public class E_LocalClass {
    void doSomething() {
        int count = 3; // effectively final

        class LocalHelper {
            void print() {
                System.out.println("Count is: " + count);
            }
        }

        LocalHelper helper = new LocalHelper();
        helper.print();
    }
}