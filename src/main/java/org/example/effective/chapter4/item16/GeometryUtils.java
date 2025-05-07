package org.example.effective.chapter4.item16;

/**
 * Point 클래스는 private static 중첩 클래스이기 때문에 외부에서 접근 불가 ❌
 * 필드 x, y도 final → 불변
 * 외부에서 x, y를 조작할 수 없음 → 캡슐화 깨지지 않음
 * 생성자에서 한 번 할당되면 값이 바뀌지 않음
 */
public class GeometryUtils {

    // private static 중첩 클래스
    private static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int calculateManhattanDistance() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 6);

        // 필드에 직접 접근해도 됨 - 안전!
        int dx = Math.abs(p1.x - p2.x);
        int dy = Math.abs(p1.y - p2.y);
        return dx + dy;
    }
}
