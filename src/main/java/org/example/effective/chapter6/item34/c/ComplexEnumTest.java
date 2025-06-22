package org.example.effective.chapter6.item34.c;

public class ComplexEnumTest {
    public static void main(String[] args) {
        double earthWeight = 185;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();


        //Enum타입은 반복 가능
        for(Planet p : Planet.values()) {
            System.out.printf("%s에서의 무게는 %f이다. %n",p,p.surfaceWeight(mass));
        }

        //널리 쓰이는 열거타입은 톱 레벨 클래스
        //특정 톱 레벨 클래스에서만 쓰이면 멤버클래스로 만든다.

    }

}
