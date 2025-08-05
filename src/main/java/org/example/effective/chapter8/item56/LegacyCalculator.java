package org.example.effective.chapter8.item56;

/**
 * {@code ICalculator}의 이전 버전 구현입니다.
 *
 * @deprecated 이 구현은 더 이상 유지되지 않으며, {@link StandardCalculator}를 사용할 것을 권장합니다.
 * @since 0.9
 */
@Deprecated
public class LegacyCalculator implements ICalculator {

    /**
     * {@inheritDoc}
     * 이 구현은 a와 b를 더한 뒤 로그를 출력합니다.
     */
    @Override
    public int add(int a, int b) {
        System.out.println("덧셈 수행 중 (레거시)");
        return a + b;
    }

    /**
     * {@inheritDoc}
     * b가 0이면 -1을 반환합니다. 예외를 발생시키지 않습니다.
     */
    @Override
    public int divide(int a, int b) {
        if (b == 0) return -1;
        return a / b;
    }
}
