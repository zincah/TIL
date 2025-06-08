package org.example.effective.chapter5.item30;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        // 1. union 사용 예제
        Set<String> set1 = Set.of("Java", "Kotlin");
        Set<String> set2 = Set.of("Scala", "Groovy");

        Set<String> result = Sets.union(set1, set2);
        System.out.println("합집합: " + result);

        // 2. 제네릭 메서드 - identity 사용
        String word = Utils.identity("Hello");
        Integer number = Utils.identity(123);
        System.out.println("문자열: " + word);
        System.out.println("숫자: " + number);
    }
}
