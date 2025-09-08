package org.example.effective.chapter9.item59;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Item 59 : 라이브러리를 익혀두면 생산성이 높아진다
 * 자바에는 아주 강력하고 잘 설계된 표준 라이브러리가 있다.
 * 직접 구현하기 전에 먼저 자바 표준 라이브러리나 외부 검증된 라이브러리를 찾아보자.
 * 이미 테스트되고 최적화된 도구를 다시 만드는 것은 번거럽고, 오류를 내기 쉽다.
 * 잘 만들어진 라이브러리를 이용하면 코드의 안정성, 성능, 생산성이 모두 향상된다.
 * 🎯 특히 다음과 같은 유틸리티 클래스들은 반드시 익혀두자:
 *
 * java.util 패키지: Collections, Arrays, Objects, Optional, Comparator 등
 * java.math 패키지: BigInteger, BigDecimal
 * java.time 패키지: LocalDate, Duration, Instant 등
 * java.nio.file, java.util.concurrent 등 고급 기능도 현업에서 매우 유용
 */
public class Main {

    static Random rnd = new Random();
    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    static int random2(int n) {
        return ThreadLocalRandom.current().nextInt(n);
    }
    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3 );
        int low = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (random2(n) < n/2)
                low++;
        }
        System.out.println(low);
    }
}
