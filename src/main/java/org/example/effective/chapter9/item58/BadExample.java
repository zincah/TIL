package org.example.effective.chapter9.item58;


import java.util.*;

/**
 * Item 58: 전통적인 for문보다는 for-each 문을 사용하라
 * 코드가 짧고 명확
 * 반복 대상의 길이나 크기를 직접 계산할 필요 없음
 * iterator를 명시적으로 사용할 필요 없음
 * 인덱스 오류, 무한 루프, 경계 오류 등의 위험 감소
 */
public class BadExample {

    public static void main(String[] args) {

        List<String> list = List.of("apple", "banana", "orange");
        // 컬렉션 순회하기
        System.out.println("1. Collection ");
        for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
            String s = i.next();
            System.out.println(s);
        }
        // 배열 순회하기
        System.out.println("2. List ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

}
