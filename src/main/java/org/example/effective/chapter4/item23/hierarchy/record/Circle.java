package org.example.effective.chapter4.item23.hierarchy.record;

/**
 * 클래스 계층 구조를 record 클래스를 사용한 예제
 * record 란?
 * 자바 14부터 도입된 불변(immutable) 데이터 클래스르 간단하게 정의한 문법
 *
 * 하위 기능 자동 생성
 * - private final 필드
 * - 생성자
 * - getter (이름은 필드명과 동일 getRadius() -> radius())
 * - equals(), hashCode(), toString() 제공
 */
public record Circle(double radius) implements Figure{

    // 추상메서드를 다형성으로 재정의
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
