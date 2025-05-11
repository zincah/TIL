package org.example.effective.chapter4.item20;


import java.util.List;

/**
 * default 메서드 선언한 인터페이스
 *
 * 디폴트 메서드 도입 이유 : 기존 인터페이스를 깨트리지 않고 새로운 기능을 덧붙일 수 있게 해줌
 * 자바 8부터 사용 가능
 *
 * 대표 예제 :
 * - List.sort(Comparator)
 * - Iterable.forEach(Consumer) : 모든 컬렉션에서 람다 기반 반복 가능
 * - Map.getOrDefault(key, defaultValue)
 */
public interface Animal {
    String sound();
    default String sleep(){
        return "동물이 잠잔다.";
    }
}
