package org.example.effective.chapter9.item62;


import org.example.effective.chapter4.item15.serializable.User;

/**
 * 다른 타입이 적절하다면 문자열 사용을 피하라
 * 1. int, enum, 플래그등 다른 타입으로 사용할 수 있는 변수를 String 타입으로 생성하면 안됨
 * 2. "AAA|17|red"와 같이 | 를 구분자로 사용하여 문자열 변수로 지정하는 대신. class로 객체화 시켜야함
 * 3. 문자열은 권한을 표현하기에 적합하지 않음
 */
public class Main {

    //ThreadLocal은 쓰레드별로 독립적으로 공유하는 값 (예 로그인 사용자 정보, DB연결 등)
    private static final ThreadLocal<String> userId = new ThreadLocal<>();
    private static final ThreadLocal<String> userRole = new ThreadLocal<>();
    private static final ThreadLocal<User> user = new ThreadLocal<>();

    public static void main(String[] args) {
        // 아래처럼 잘못입력할 수 있는 경우 생김, 권한부여 관련 변수인 경우 치명적
        userId.set("userRole");
        userRole.set("userId");


        // 타입을 명시하여 잘못된 값이 안들어 가도록 보호
        user.set(new User("","aa"));


    }
}
