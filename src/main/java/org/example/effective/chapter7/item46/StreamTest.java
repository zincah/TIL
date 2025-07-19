package org.example.effective.chapter7.item46;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 스트림 요소를 처리할 때는 반드시 순수 함수를 사용해야 함.
 * 순수 함수란:
 * - 부작용(side effect)이 없음
 * - 동일한 입력 → 항상 동일한 출력 반환
 * - 외부 상태를 변경하지 않음
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        // 스트림 코드를 가장한 반복적 코드
        // forEach 연산은 스트림 계산 결과를 보고할 때만 사용
        // 계산하는 데는 쓰지 말자
        System.out.println("\n잘못된 방식 (부작용 발생 가능, 예제 전용):");
        Map<String, Integer> unsafeCount = new HashMap<>();
        words.forEach(word -> {
                unsafeCount.merge(word, 1, Integer::sum);
        }); // 부작용 (side effect): 람다가 상태를 수정

        unsafeCount.forEach((word, count) ->
                System.out.println(word + ": " + count
        ));


        // 권장 방식: Collectors.groupingBy 사용
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),    // 어떤 키로 그룹핑할지: 단어 자체
                        Collectors.counting()  // 각 키에 몇 번 등장했는지를 세는 downstream collector
                ));

        System.out.println("🥝 단어 개수 (groupingBy):");
        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));

    }
}
