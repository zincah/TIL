package org.example.effective.chapter7.item42;

import java.util.*;

/**
 * 람다식을 활용하는 이유
 *
 * - 코드가 어떤 동작을 하는지가 명확하게 드러나기에 사용
 * - 간단한 함수형 인터페이스 구현에는 항상 람다를 우선 사용
 * - 가독성이나 의미 전달이 떨어진다면 람다를 쓰지 말아야 함
 */
public class LamdaEx {

    public static List<String> words = new ArrayList<>();

    public static void main(String[] args) {

        words.add("apple");
        words.add("banana");
        words.add("car");
        words.add("elephant");

        // 익명 클래스의 인스턴스를 함수 객체로 사용 - 낡은 기법
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // 람다식을 함수 객체로 사용
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // 메서드 참조 방식으로 내부적으로 람다 활용
        Collections.sort(words, Comparator.comparingInt(String::length));

        // List 자체의 sort() 사용
        words.sort(Comparator.comparingInt(String::length));

        for(String word : words){
            System.out.println(word);
        }
    }
}




