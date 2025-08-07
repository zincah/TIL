package org.example.effective.chapter8.item49;

import java.math.BigInteger;
import java.util.Objects;

/**
 * 매개변수가 유효한지 검사하라
 * 매개변수들에 어떤 제약이 있을지 생각하라
 * 제약들을 문서화 하고 메서드 코드 시작 부분에서 명시적으로 검사해야한다.
 *
 */
public class Item49 {

    public static void main(String[] args) {

        // test 1
        //BigInteger m1 = mod(BigInteger.valueOf(0));
        //BigInteger m2 = mod(null);

        // test2
        long[] a = {1, 2, 3};
        sort(a, 20, 2);
    }

    /**
     * (현재 값 mod m) 값을 반환한다.
     * @param bigInt 계수 (양수)
     * @return 현재 값 mod m
     * @throws ArithmeticException m이 0보다 작거나 같으면 발생한다.
     */
    public static BigInteger mod(BigInteger bigInt) {
        BigInteger m = Objects.requireNonNull(bigInt);

        if (m.signum() <= 0) {
            throw new ArithmeticException("계수(m)는 양수여야 합니다. " + m);
        }
        // 계산 수행
        return null;
    }

    // vm 옵션에 -ea를 추가했을 경우만 에러 발생
    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;

        // 계산 수행
    }

}
