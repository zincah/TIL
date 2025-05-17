package org.example.effective.chapter4.item23.hierarchy.record;

public record Rectangle(double length, double width) implements Figure{
    @Override
    public double area() {
        return length * width;
    }
}
