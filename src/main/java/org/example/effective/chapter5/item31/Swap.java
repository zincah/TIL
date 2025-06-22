package org.example.effective.chapter5.item31;

import java.util.*;

public class Swap {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("Java", "Kotlin", "Scala"));
        System.out.println("Before swap: " + words);

        swap(words, 0, 2);

        System.out.println("After swap: " + words); // [Scala, Kotlin, Java]
    }

    // List<?>, 즉 "원소 타입을 모르는 리스트"에 저장된 값을 변경하려 하므로 컴파일 오류가 발생
//    public static void badSwap(List<?> list, int i, int j) {
//        Object tmp = list.get(i);
//        list.set(i, list.get(j)); // 컴파일 에러
//        list.set(j, tmp);          // 컴파일 에러
//    }

    // 외부 노출되는 메서드: List<?> 사용 (타입 유추 불가 → 쓰기 불가)
    public static void swap(List<?> list, int i, int j) {
        // 내부 제네릭 헬퍼 메서드 호출
        swapHelper(list, i, j);  // → List<?>는 타입 파라미터 T로 자동 캐스팅됨
    }

    // 내부 도우미 메서드: 제네릭을 도입하여 타입 추론 가능
    private static <T> void swapHelper(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}