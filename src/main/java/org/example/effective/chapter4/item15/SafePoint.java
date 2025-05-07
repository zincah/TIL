package org.example.effective.chapter4.item15;

/**
 * 캡슐화 + 메서드 제어
 *
 * - x, y를 한 번에 안전하게 변경할 수 있음
 * - 외부는 move() 메소드를 통해서만 필드에 접근 가능
 */
public class SafePoint {

    private int x;
    private int y;

    public synchronized void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        // 여기에 로깅, 검증, 이벤트 트리거 등도 가능
    }

    public synchronized int getX() { return x; }
    public synchronized int getY() { return y; }

}
