package org.example.effective.chapter3.item15;

/**
 * public 가변 필드를 갖는 클래스는 일반적으로 스레드 안전하지 않다.
 *
 * - 외부에서 직접 수정 가능
 * - 동기화 불가능
 */
public class UnsafePoint {
    public int x;
    public int y;
}
