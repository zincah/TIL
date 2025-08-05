package org.example.effective.chapter8.item56;

/**
 * 기본적인 계산 기능을 제공하는 <i>계산기 인터페이스</i>입니다.
 *
 * @since 1.0
 */
public interface ICalculator {

    /**
     * 두 수의 합을 계산합니다.
     *
     * @param a 첫 번째 정수
     * @param b 두 번째 정수
     * @return a와 b의 합
     * @implSpec 이 메서드는 오버플로우를 검사하지 않으며,
     * 구현체는 오버플로우 여부를 검사할 수 있습니다.
     */
    int add(int a, int b);

    /**
     * 두 수의 나눗셈을 계산합니다.
     *
     * @param a 피제수
     * @param b 제수 (0이면 안 됨)
     * @return 정수 나눗셈 결과
     * @throws ArithmeticException 0으로 나눌 경우
     */
    int divide(int a, int b);
}
