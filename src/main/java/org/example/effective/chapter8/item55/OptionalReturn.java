package org.example.effective.chapter8.item55;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 아이템 55 : 값이 없을 수도 있다는 것을 나타낼 때 null 보다 Optional<T>를 사용하되, 모든 곳에 남용하지 말고, 반환값 용도에 한정해서 신중히 사용해라
 * Optional 등장 이유 : 메소드가 null을 반환하면, 호출자는 항상 null 체크를 해야하고 실수로 NullPointerException이 발생할 수 있음. 따라서 값이 없을 수도 있음을 명시적으로 표현하는 수단
 *
 * Optional 사용 좋은 예
 */
public class OptionalReturn {

    private static final Map<String, String> userMap = Map.of(
            "alice", "Alice Kim",
            "bob", "Bob Lee"
    );

    public static Optional<String> findUser(String username){
        return Optional.ofNullable(userMap.get(username));
        // 값이 없는 경우 Optional.empty() 객체 반환 (null 반환 x)
    }

    public static void main(String[] args) {

        // ✅ ifPresent: 값이 있을 때만 실행 : 메소드 실행 결과의 값이 있을 수도 없을 수도 있기에 값이 있을 때만 실행하는 조건을 명시적으로 건다고 해석됨
        findUser("alice").ifPresent(name -> System.out.println("* ifPresent 사용 - 값이 있을 때만 실행 [" + name + "]"));

        // ✅ ifPresentOrElse: 값 없을 때도 처리 가능
        findUser("charlie").ifPresentOrElse(
                name -> System.out.println("* ifPresentOrElse 사용 - 찾으려는 값 [" + name + "]"),
                () -> System.out.println("* ifPresentOrElse 사용 - 찾으려는 값이 없는 경우")
        );

        // ✅ map: Optional 안의 값을 변환
        String upperName = findUser("alice").map(String::toUpperCase).orElse("UNKNOWN");
        System.out.println("* map + orElse 사용 [" + upperName + "]");

        // ✅ orElseThrow: 값이 없으면 예외 발생
        try{
            String user = findUser("bob")
                    .orElseThrow(() -> new NoSuchElementException("찾으려는 값이 없음"));
            System.out.println("* orElseThrow 사용 - 찾으려는 값 [" + user + "]");

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            String user = findUser("charlie")
                    .orElseThrow(() -> new NoSuchElementException("찾으려는 값이 없음"));
            System.out.println("* orElseThrow 사용 - 찾으려는 값 [" + user + "]");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
