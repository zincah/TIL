package org.example.effective.chapter4.item16;

import java.awt.*;

public class Main {


    public static void main(String[] args) {
        testPoint();
    }

    /**
     * Public 클래스의 필드를 노출한 사례
     * java.awt.Point
     *
     * 1. 캡슐화 개짐
     *  p1.x = -9999; 처럼 외부에서 필드 값 변경 가능
     *  클래스 내부 불변식이 있다면 유지가 어려움
     * 2. 변경 불가능한 API 계약
     *  일단 필드를 public으로 공개하면 그게 API 계약이 된다.
     *  추후에 이 필드를 private로 바꾸거나 getter/setter 방식으로 변경하고 싶어져도,
     *  기존 사용자들 때문에 API 변경 불가
     */
    public static void testPoint() {
        Point p1 = new Point(0, 0);
        System.out.println("Point p1(" + p1.x + ", " + p1.y + ")");

        p1.x = -9999;
        System.out.println("Point p1(" + p1.x + ", " + p1.y + ")");
    }


}
