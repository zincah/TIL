package org.example.effective.chapter2.item6;

import java.util.regex.Pattern;

/**
 * item6 : 불필요한 객체 생성을 피하라
 * 불변 객체는 새로 만들지 말고, 공유하거나 재사용하기
 */
public class AvoidUnnecessaryObject {

    private static final Pattern SPLIT_PATTERN
            = Pattern.compile(",");

    public static void main(String[] args) {
        // 1. string 비교
        String a = new String("hello"); // 새 객체 생성
        String b = "hello"; // 문자열 리터럴 재사용

        // 2. Boolean.valueOf()
//        Boolean bool1 = new Boolean(true);
        Boolean bool2 = Boolean.valueOf(true);

        // 3. 박싱 타입 (Wrapper 클래스)의 캐싱
//        Integer intA = new Integer(100);
        Integer intB = Integer.valueOf(100); // -128 ~ 127 범위 캐싱

        // 4. 불변 객체는 static final 로 재사용
        split1("hi,im ahyeon"); // 잘못 사용한 예
        split2("hi,im ahyeon");

    }

    public static String[] split1(String input){
        // 매번 새로운 Pattern 객체 생성
        return Pattern.compile(",").split(input);
    }

    public static String[] split2(String input){
        return SPLIT_PATTERN.split(input);
    }

}
