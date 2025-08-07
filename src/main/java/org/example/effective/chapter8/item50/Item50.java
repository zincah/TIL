package org.example.effective.chapter8.item50;

import java.util.Date;

/**
 * 적시에 방어적 복사본을 만들라.
 * - 클래스가 클라이언트로 받는 혹은 반환하는 구성요소가 가변이라면
 *      그 요소는 반드시 방어적으로 복사해야 한다.
 * - 복사 비용이 너무 크거나 클라이언트가 요소를 잘못 수정할 일이 없음을 신뢰한다면
 *      방어적 복사 대신 해당 구성요소를 수정했을 떄 책임을 명시해라.
 */
public class Item50 {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        BadPeriod badPeriod = new BadPeriod(start, end);

        System.out.println("1. Bad example");
        System.out.println(badPeriod);
        end.setYear(78); // p의 내부를 수정했다.
        System.out.println(badPeriod);

        System.out.println("2. Good example");
        start = new Date();
        end = new Date();
        GoodPeriod goodPeriod = new GoodPeriod(start, end);

        System.out.println(goodPeriod);
        end.setYear(78);
        System.out.println(goodPeriod);
        goodPeriod.end().setYear(79);
        System.out.println(goodPeriod);
    }
}
