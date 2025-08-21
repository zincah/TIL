package org.example.effective.chapter9.item64;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 결론
 * - 변수, 매개변수, 반환 타입은 되도록 인터페이스로 선언
 * - 구현체는 생성할 때만 사용하면 충분
 * - 구현체가 바뀌어도 코드 수정 최소화 가능
 */
public class GoodExample {

    public static void main(String[] args) {
        // 인터페이스(List)로 선언 → 구현체는 ArrayList
        List<String> users = new ArrayList<>();
//        List<String> users = new LinkedList<>();

        // ArrayList -> LinkedList 로 변경할 때 생성자 한줄만 바꾸면 끝

        users.add("Alice");
        users.add("Bob");
        users.add("Charlie");

        printUsers(users);
    }

    // 인터페이스(List)를 매개변수 타입으로 사용
    // List 인터페이스만 알고 있으면 되기에 확장성, 재사용성이 향상
    public static void printUsers(List<String> users) {
        for (String user : users) {
            System.out.println("User: " + user);
        }
    }
}
