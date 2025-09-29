package org.example.effective.chapter10.item74;

public class Caculator {

    // 잘못된 예 – 예외를 선언했지만 문서화하지 않음
    public static int badDivide(int a, int b) {
        return a / b; // b가 0이면 ArithmeticException 발생
    }

    // 좋은 예 – 예외를 명확히 문서화한 버전
    /**
     * 두 정수를 나누어 결과를 반환합니다.
     *
     * @param a 피제수
     * @param b 제수 (0이 아니어야 합니다)
     * @return a를 b로 나눈 값
     * @throws ArithmeticException 제수가 0일 경우 나눗셈이 불가능하여 예외가 발생합니다.
     */
    public static int goodDivide(int a, int b) {
        return a / b;
    }

    /**
     * 문자열을 정수로 파싱합니다.
     *
     * @param input 숫자 형식의 문자열
     * @return 정수
     * @throws NumberFormatException 문자열이 정수가 아닐 경우
     * @throws NullPointerException input이 null인 경우
     */
    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
