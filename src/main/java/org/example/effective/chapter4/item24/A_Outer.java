package org.example.effective.chapter4.item24;

/**
 * 자바에서의 중첩클래스
 * 1. 정적 멤버 클래스 (static member class) - static class Inner {}
 * 2. 비정적 멤버 클래스 (non-static member class) - class Inner {}
 * 3. 지역 클래스 (local class) - (메서드 안에서) class Foo{}
 * 4. 익명 클래스 (anonymous class) - 이름없이 한번만 사용 new Runnable(){...}
 *
 * 챕터 24 핵심 내용
 * 바깥 인스턴스를 참조하는 경우가 아니면 멤버클래스는 "정적 멤버 클래스"로 만들어야한다.
 *
 *
 */
public class A_Outer {
    private String outerValue = "This is Outer class field.";

    // 비정적 멤버 클래스 (외부 참조 가능)
    class NonStaticInner {
        public void accessOuter() {
            System.out.println("NonStaticInner: " + outerValue); // 접근 가능
            /**
             * 외부참조를 하여 저장하는 경우 바깥 클래스의 인스턴스를 수거하지못하여 메모리 누수 가능성 생김
             */
        }
    }

    // 정적 멤버 클래스 (외부 참조 불가능)
    static class StaticInner {
        public void accessOuter() {
            // System.out.println("StaticInner: " + outerValue); // 컴파일 에러 발생
            System.out.println("StaticInner: Cannot access outerValue directly.");
        }
    }

    // 테스트 실행
    public static void main(String[] args) {
        // 바깥 클래스 인스턴스 생성
        A_Outer outer = new A_Outer();

        // 비정적 멤버 클래스 인스턴스 생성 (Outer 인스턴스 필요)
        NonStaticInner nonStaticInner = outer.new NonStaticInner();
        nonStaticInner.accessOuter(); // 출력: outerValue 값

        // 정적 멤버 클래스 인스턴스 생성 (Outer 인스턴스 없이 가능)
        StaticInner staticInner = new StaticInner();
        staticInner.accessOuter(); // 출력: 접근 불가 메시지
    }
}
