package org.example.effective.chapter8.item56;

/**
 * {@code ICalculator}의 표준 구현체입니다.
 *
 * @since 1.0
 */
public class StandardCalculator implements ICalculator {

    /**
     * 기본 생성자입니다.
     * 특별한 초기화는 없습니다.
     */
    public StandardCalculator() {
    }

    /**
     * {@inheritDoc}
     * 구현은 단순히 {@code a + b}를 반환합니다.
     */
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * {@inheritDoc}
     * 구현은 {@code a / b}를 수행하며, b가 0일 경우 {@link ArithmeticException}을 던집니다.
     */
    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
