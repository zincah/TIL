package org.example.effective.chapter4.item23.tag;

/**
 * 태그 달린 클래스란?
 * 하나의 클래스가 여러 타입의 역할을 하며, 내부에 타입 구분용 필드(tag)를 가지는 방식
 *
 * 태그가 필요한 이유는 보통 하나의 클래스 안에서 서로 다른 동작이나 데이터를 구분하려고 할때 필요하다고 느껴진다.
 *
 * 태그의 문제점
 * - 모든 인스턴스가 불필요한 필드를 가지게 됨
 * - switch 로 동작을 분기하므로 코드가 절차지향적으로 바뀜
 * - 타입 시스템이 제공해주는 다형성이 무시됨
 * - 새로운 타입을 추가할 때 기존 코드를 수정해야함 (OCP 위반)
 */
public class Figure {

    enum Shape { RECTANGLE, CIRCLE } // tag

    final Shape shape;

    // for rectangle
    double length;
    double width;

    // for circle
    double radius;


    Figure(double length, double width){
        this.shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    Figure(double radius){
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    double area() {
        switch (shape) {
            case RECTANGLE: return length * width;
            case CIRCLE: return Math.PI * (radius * radius);
            default: throw new AssertionError(shape);
        }
    }

}
