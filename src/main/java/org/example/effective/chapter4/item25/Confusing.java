package org.example.effective.chapter4.item25;

/**
 * 하나의 자바파일엔 하나의 톱레벨 클래스만 선언
 * 톱 레벨 클래스란
 *  - public class ClassName 또는 (default) class ClassName
 * 한 파일에는 단 하나의 public 클래스만 가능하고, 파일이름은 반드시 그 클래스 이름과 같아야함
 */

class Dog {
    static final String SOUND = "bark";
}

public class Confusing {
    public static void main(String[] args) {
        //어떤 Dog를 사용해야할지 모름. 환경에 따라 달라짐
        // 인텔리제이는 Duplicate class Helper 라고 경고하며 컴파일 차단
        System.out.println(Dog.SOUND);
    }
}
