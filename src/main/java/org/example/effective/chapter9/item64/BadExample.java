package org.example.effective.chapter9.item64;

import java.util.ArrayList;
import java.util.List;

/**
 * 아이템 64 : 객체는 인터페이스를 사용해 참조하라
 *
 * 인터페이스로 참조해야하는 이유
 * 1. 유연한 코드 -> 구현체 변경 용이
 * 2. 결합도 감소 : 구현체에 직접 의존하지 않기 때문에 코드의 재사용성과 테스트 용이성이 높아짐
 * 3. 테스트/모킹 용이 : List나 Map같은 인터페이스를 사용하면 테스트용 구현체로 바꾸기 쉬움
 */
public class BadExample{

    public static void main(String[] args) {
        // 구체 클래스(ArrayList)로 선언
        ArrayList<String> users = new ArrayList<>();

        users.add("Alice");
        users.add("Bob");
        users.add("Charlie");

        printUsers(users);
    }

    // 매개변수도 구체 클래스에 의존하고 있음
    public static void printUsers(ArrayList<String> users) {
        for (String user : users) {
            System.out.println("User: " + user);
        }
    }
}
