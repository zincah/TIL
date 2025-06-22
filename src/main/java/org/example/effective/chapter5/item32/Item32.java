package org.example.effective.chapter5.item32;

import java.util.List;
import java.util.ArrayList;

/**
 * 가능한 한 제네릭 + 가변인자 조합은 피하자.
 * - 제네릭 타입은 런타임에 "타입 소거" 되기 때문에 매개변수 오염(Heap Pollution)의 문제가 발생
 * 정말 필요한 경우엔:
 * - @SafeVarargs 어노테이션 사용
 * - 내부에서 절대 수정하지 않을 것 (읽기 전용으로 사용)
 * - 문서화로 해당 경고를 사용자에게 명확히 전달
 */
public class Item32 {

    public static void main(String[] args) {

        try {
            dangerous(List.of("A", "B"), List.of("C", "D"));
        } catch (ClassCastException e) {
            System.out.println("ClassCastException 발생" + e);
        }

        List<String> result = flatten(List.of("A", "B"), List.of("C", "D"));
        System.out.println("Flattened: " + result); // [A, B, C, D]
    }

    // 안전하게 사용하는 제네릭 + 가변인자 메서드 (@SafeVarargs 적용)
    @SafeVarargs
    public static <T> List<T> flatten(List<T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    // 다음은 위험할 수 있는 예시 (사용 금지 또는 주의)

    public static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;               // 힙 오염 발생
        String s = stringLists[0].get(0);   // ClassCastException
    }

}