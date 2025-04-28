package org.example.effective.chapter3.item10;

public class ColorPoint extends Point {
    private final String color;

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, "RED");

        System.out.println(p.equals(cp));   // true
        System.out.println(cp.equals(p));   // false
    }

    public ColorPoint (int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
