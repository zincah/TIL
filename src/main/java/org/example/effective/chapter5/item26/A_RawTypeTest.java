package org.example.effective.chapter5.item26;
import java.util.ArrayList;
import java.util.List;

/**
 * 무조건 로 타입 대신 제네릭 타입을 사용해야한다.
 * 예외로 instance of 체크시에만 로타입 사용
 */
public class A_RawTypeTest {

    public static void main(String[] args) {

        // 로 타입 사용
        List rawList = new ArrayList(); // 경고 발생 (unchecked assignment)
        rawList.add("hello");
        rawList.add(123); // 서로 다른 타입 허용됨

        for (Object obj : rawList) {
            System.out.println("rawList contains: " + obj);
        }

        try {
            String value = (String) rawList.get(1); // ClassCastException
            System.out.println("Casted value: " + value);
        } catch (ClassCastException e) {
            System.out.println("Runtime Error: " + e);
        }

        // 제네릭 타입 사용
        List<String> genericList = new ArrayList<>();
        genericList.add("hello");
        // genericList.add(123); // 컴파일 에러 발생

        for (String str : genericList) {
            System.out.println("genericList contains: " + str);
        }

        // 안전한 타입 추출
        String val = genericList.get(0);
        System.out.println("safe value: " + val);
    }
}