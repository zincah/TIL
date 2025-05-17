package org.example.effective.chapter4.item23.hierarchy;

/**
 * 태그 달린 클래스 대신 권장 방식
 * 클래스 계층 구조 사용 클래스
 * -> 추상 클래스 (또는 인터페이스) + 구체 서브 클래스
 *
 * - 필요한 필드만 가짐
 * - 다형성으로 깔끔해짐
 * - 유지보수와 확장성 뛰어남
 */
abstract class Figure {
    abstract double area();
}

class Circle extends Figure{
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * (radius * radius);
    }

    public double getRadius(){
        return radius;
    }
}

class Rectangle extends Figure{
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
