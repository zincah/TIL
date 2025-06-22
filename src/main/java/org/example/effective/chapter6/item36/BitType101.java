package org.example.effective.chapter6.item36;

// 비트타입이랑 하나의 숫자안에 여러개의 상태(정보)를 비트단위로 담는 방식
public class BitType101 {

    // LightA~D까지 조명 켜짐/꺼짐 상태를 나타내는 테스트
    public static void main(String[] args) {
        //비트타입을 사용하지 않는 경우
        boolean lightA =true;
        boolean lightB =false;
        boolean lightC =true;
        boolean lightD =false;


        //비트타입을 사용하는 경우
        int LIGHT_A = 1 << 0; // 0001
        int LIGHT_B = 1 << 1; // 0010
        int LIGHT_C = 1 << 2; // 0100
        int LIGHT_D = 1 << 3; // 1000

        // int 하나에 어떤 조명이 켜졌는지 담을 수 있음
        int lights = LIGHT_A | LIGHT_C; // 0001 | 0100 = 0101
        System.out.println("lights " + lights); // 5

        boolean isLightAOn = (lights & LIGHT_A) != 0; // true
        System.out.println("isLightAOn " + isLightAOn);
        boolean isLightBOn = (lights & LIGHT_B) != 0; // false
        System.out.println("isLightBOn " + isLightBOn);



    }

    /**
     * 장점
     * - 적은 메모리 사용
     * - 연산이 빠름
     * - 여러개를 한 번에 조합하기 쉬움
     *
     * 단점
     * - 코드이해가 어려움
     * - 값별로 뜻을 모르면 헷갈림
     * - 타입 안정성이 없음 (int 타입이라 다양한 값을 할당할 수 있음)
     */
}
