package org.example.effective.chapter7.item46;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        //List<String> words = List.of("apple", "banana", "orange");
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana");

        // toMap(keyMapper, valueMapper)
        try {
            // 단어를 key, 길이를 value로
            Map<String, Integer> map = words.stream()
                    .collect(Collectors.toMap(
                            word -> word,         // keyMapper
                            String::length              // valueMapper
                    ));

            System.out.println(map); // {orange=6, banana=6, apple=5}
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException 발생!!!");
        }

        // toMap(keyMapper, valueMapper, mergeFunction)
        // 단어별 등장 횟수를 구하기
        Map<String, Integer> freqMap = words.stream()
                .collect(Collectors.toMap(
                        word -> word,       // keyMapper
                        word -> 1,          // valueMapper (초기값은 1)
                        Integer::sum              // mergeFunction: 기존값 + 새값
                ));

        System.out.println(freqMap); // {orange=1, banana=2, apple=2}

        // toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)
        // 키 순서대로 정렬되게 TreeMap을 명시적으로 지정
        Map<String, Integer> freqMap2 = words.stream()
                .collect(Collectors.toMap(
                        word -> word,                 // keyMapper
                        word -> 1,                    // valueMapper
                        Integer::sum,                       // mergeFunction
                        TreeMap::new                        // mapSupplier: TreeMap 사용
                ));

        System.out.println(freqMap2); // {apple=2, banana=2, orange=1} (정렬된 맵)
    }

}
