package org.example.effective.chapter5.item31;

import java.util.*;

/**
 * 제네릭 타입 매개변수를 사용할 때는 "와일드카드 타입 (wildcard type)"
 * — 특히 한정적 와일드카드(bounded wildcard)를 적절히 사용하면
 * API의 유연성을 높일 수 있다.
 *
 * 자바 제네릭의 PECS 원칙(Public/Producer-extends, Consumer-super)
 * - 쓰기 전용 생성자용 매개변수: <? extends T> T 또는 T의 하위 타입 (생산자)
 * - 읽기 전용 소비자용 매개변수: <? super T> T 또는 T의 상위 타입 (소비자)
 * 호출 쪽에서 더 다양한 타입을 수용할 수 있어서 API 유연성이 높아진다.
 */
class Item31 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        List<Object> objects = new ArrayList<>();

        BadStack<Number> badStack = new BadStack<>();

        // pushAll에 정확히 E 타입의 Iterable만 전달 가능
        // 즉, Stack<Number> 에 pushAll(List<Integer>) 와 같이 하위 타입 전달 불가
        // Integer는 Number의 하위 타입이므로 정상동작 할 것 같지만 실제로는 오류 발생
        // 매개변수화 타입이 불공변이기 때문
//        badStack.pushAll(integers);
//        badStack.popAll(objects);

        GoodStack<Number> goodStack = new GoodStack<>();
        goodStack.pushAll(integers);  // List<Integer> → Stack<Number>
        goodStack.popAll(objects);    // Stack<Number> → List<Object>

        System.out.println("Pop된 객체들: " + objects);
    }
}
