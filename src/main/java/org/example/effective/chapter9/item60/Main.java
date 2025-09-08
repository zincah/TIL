package org.example.effective.chapter9.item60;

import java.math.BigDecimal;

/**
 * Item 60 요약
 * float과 double은 근사값(approximation)을 다루는 데 적합한 타입이지,
 * 정확한 숫자 계산(특히 금전 계산 등)을 위한 타입이 아니다.
 */
public class Main {

    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println("구매한 아이템 수: " + itemsBought);
        System.out.println("남은 잔액: " + funds);

        // BigDecimal은 정확한 값을 사용할 수 있지만 사용이 불편하고 느리다.
        // int 혹은 long 타입을 사용할 경우 값의 크기가 제한되고 소수점을 직접 관리해야 한다.
        BigDecimal funds2 = new BigDecimal("1.00");
        BigDecimal price2 = new BigDecimal("0.10");
        int itemsBought2 = 0;
        while (funds2.compareTo(price2) >= 0) {
            funds2 = funds2.subtract(price2);
            itemsBought2++;
        }
        System.out.println("구매한 아이템 수: " + itemsBought2);
        System.out.println("남은 잔액: " + funds2);
    }
}
