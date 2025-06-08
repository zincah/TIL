package org.example.effective.chapter5.item28;

import java.util.ArrayList;
import java.util.List;

public class ArrayVsList {

    public static void main(String[] args) {
        System.out.println("1. [배열은 런타임 타입 검사 - ArrayStoreException 발생]");
        try {
            Object[] objectArray = new Long[1];         // Long 타입 배열 생성
            objectArray[0] = "타입이 달라 넣을 수 없다.";   // String 넣음 -> 런타임 오류
        } catch (ArrayStoreException e) {
            System.out.println("ArrayStoreException 발생" + e);
        }

        System.out.println("\n 2. [제네릭 List는 컴파일 타임에 타입 검사]");
        // List<Object> objectList = new ArrayList<Long>(); // 컴파일 에러
        List<Object> objectList = new ArrayList<>();
        objectList.add("문자열");
        objectList.add(123);

        for (Object obj : objectList) {
            System.out.println("리스트 요소: " + obj);
        }

        System.out.println("\n 3. [제네릭 배열 생성 불가 → 직접 시도해보면 컴파일 에러]");
        //String[] stringArray = new String[10];            // 가능
        //List<String>[] listArray = new List<String>[10];  // 컴파일 불가

        System.out.println(" 제네릭 배열을 사용하는 대신 List<List<E>>를 고려하세요.");

        System.out.println("\n 4. [대안: List를 사용해서 제네릭 타입 안전하게 다루기]");
        List<List<String>> listOfLists = new ArrayList<>();
        List<String> inner = new ArrayList<>();
        inner.add("Hello");
        inner.add("World");
        listOfLists.add(inner);

        for (List<String> strs : listOfLists) {
            System.out.println("내부 리스트: " + strs);
        }

        System.out.println("\n 5. [제네릭 배열 생성의 문제점 예시]");
        /*
        1. 배열은 공변(covariant)
            예: String[]은 Object[]로 업캐스팅 가능
        2. 제네릭은 불공변(invariant)
            제네릭 타입 List<Integer> ≠ List<Object>
        3. 제네릭 배열 생성은 컴파일 시 타입 정보 소거 → 타입 안전하지 않음
         */
        try {
            List<String>[] stringLists = new List[1];   // 컴파일 경고
            List<Integer> intList = List.of(42);    // 자바 9부터 가능
            Object[] objects = stringLists;             // 배열은 공변 -> Object[] ok
            objects[0] = intList;                       // 배열 요소 교체 (List<Integer>로)
            String s = stringLists[0].get(0);           // 런타임에서 ClassCastException 발생
        } catch (ClassCastException e) {
            System.out.println("ClassCastException 발생" + e);
        }
    }
}
