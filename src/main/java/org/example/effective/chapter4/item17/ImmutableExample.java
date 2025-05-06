package org.example.effective.chapter4.item17;

import java.util.Date;

/**
 * 불변 객체(Immutable Object)란?
 *
 * 객체 생성 이후 상태가 절대 변하지 않는 객체.
 * 외부에서 이 객체의 필드를 수정할 수 없고, 모든 변경은 새로운 객체를 생성함.
 * 자바의 String, Integer 등이 대표적인 불변 객체.
 * 📌 불변 객체의 장점
 * 안전성: 여러 스레드에서 동시에 사용해도 안전함 (Thread-safe).
 * 신뢰성: 상태를 추적하거나 추론하기 쉬움 (디버깅 용이).
 * 간결성: 상태 추적, 방어적 복사 코드 불필요.
 * 장기적 유연성: 불변 객체를 안전하게 캐싱하거나 공유할 수 있음.
 * 📌 불변 객체 설계 방법
 * 클래스를 final로 선언 (상속 불가)
 * 모든 필드를 private final로 선언
 * 변경 메서드 대신 값을 반환하는 "함수형 메서드" 제공
 * 변경 가능한 내부 객체를 사용할 경우, 방어적 복사(defensive copy) 필요
 */
public class ImmutableExample {
    public static void main(String[] args) {
        System.out.println("✅ [1. 불변 객체 생성 및 사용]");
        Money m1 = new Money(1000);
        Money m2 = m1.add(new Money(500));

        System.out.println("원본 객체 m1: " + m1.getAmount());
        System.out.println("새로운 객체 m2: " + m2.getAmount());

        System.out.println("\n✅ [2. 내부 가변 객체를 방어적으로 복사]");
        TimePeriod tp1 = new TimePeriod(new Date(), new Date(System.currentTimeMillis() + 10000));
        System.out.println("시작 시간: " + tp1.getStart());
        System.out.println("끝 시간: " + tp1.getEnd());

        // 외부에서 반환된 객체를 수정해도 내부 상태 변화 없음
        Date hackedStart = tp1.getStart();
        hackedStart.setTime(0);

        System.out.println("변조된 시작 시간: " + hackedStart);
        System.out.println("TimePeriod의 시작 시간 (불변 유지): " + tp1.getStart());
    }
}
