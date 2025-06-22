package org.example.effective.chapter6.item34.b;


/**
 * 다른 열거 타입끼리 비교 불가능.
 * toString으로 출력시 상수값이 아닌 적합한 문자열 반환
 * 임의 필드, 메서드, 인터페이스 구현 가능
 * Object 메서드들과  Comparable, Serializable도 구현 해놓음
 */
public class SimpleEnumTest {
    public static void main(String[] args) {
        System.out.println(Apple.FUJI);
        System.out.println(Orange.TEMPLE);
        //System.out.println(Apple.FUJI == Orange.TEMPLE); // 비교 불가능

    }


}

