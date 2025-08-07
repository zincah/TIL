package org.example.effective.chapter8.item50;

import java.util.Date;

/**
 * - 생성자에게서 받은 가변 매개변수를 각각 방어적으로 복사(defensive copy)
 * - 매개변수의 유효성을 검사하기 전에 방어적 복사본 생성
 * - 멀티스레딩 환경에서 유효성을 검사한 후 복사본을 만드는
 *      순간에 다른 스레드가 원본 객체를 수정할 위험이 있다.
 * - 방어적 복사에 clone을 사용하지 않음
 *      clone이 Date를 확장하는 하위클래스를 반환할 수 있음
 */
public class GoodPeriod {
    private final Date start;
    private final Date end;

    public GoodPeriod(Date start, Date end) {
this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(
                    start + "가 " + end + "보다 늦다.");
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return "start: " + start.toString() + " / end: " + end.toString();
    }
}
