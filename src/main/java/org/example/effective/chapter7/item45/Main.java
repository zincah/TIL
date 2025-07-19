package org.example.effective.chapter7.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 스트림은 주의해서 사용하라
 * - 스트림은 모든 상황에 적합한건 아니다.
 * - 명확성, 디버깅, 가독성, 흐름제어를 고려했을 때는 for 문이 훨씬 낫다
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        int sum = list.stream() // 소스 스트림으로 시작
                .filter(n -> n > 0) // 중간연산1
                .mapToInt(n -> n) // 중간연산2
                .sum(); // 종단연산. 종단연산이 없는경우 아무일도 하지 않은 명령어


        // 직관적으로 알기 어려운 복잡한 스트림
        int n = 10;
        IntStream.range(0, n)
                .forEach(i -> IntStream.range(i, n)
                        .filter(j -> isValid(i, j))
                        .forEach(j -> process(i, j)));

        // 훨씬 명확함
        // - 제어 흐름이 명확
        // - 디버깅, 로깅도 쉬움
        // - 중간에 break/continue 같은 제어도 가능
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isValid(i, j)) {
                    process(i, j);
                }
            }
        }

    }

    private static boolean isValid(int i, int j) {
        return true;
    }

    private static void process(int i, int j) {

    }


}


