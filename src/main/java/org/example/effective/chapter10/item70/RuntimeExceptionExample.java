package org.example.effective.chapter10.item70;

public class RuntimeExceptionExample {

    // 숫자는 반드시 양수여야 한다는 메서드 계약(Contract)을 정의합니다.
    public double calculateSquareRoot(int number) {

        // 인자의 유효성 검사 (입력값 확인)
        if (number < 0) {
            // IllegalArgumentException은 런타임 예외입니다.
            // "API 사용 계약을 위반했다"는 의미로 사용됩니다.
            throw new IllegalArgumentException("인자는 음수일 수 없습니다: " + number);
            // 호출자가 이 예외를 catch하여 복구할 방법은 거의 없습니다.
            // (잘못된 코드를 수정해야 합니다.)
        }

        return Math.sqrt(number);
    }

    public static void main(String[] args) {
        RuntimeExceptionExample example = new RuntimeExceptionExample();

        // 잘못된 사용 예시 (개발자 실수)
        try {
            double result = example.calculateSquareRoot(-4); // 계약 위반
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            // 런타임 예외를 catch하는 경우는 보통 최종 로깅, 또는 시스템 종료 직전 처리입니다.
            // 런타임 예외를 catch 하면 강제종료 안됨
            System.err.println("ERROR !!!!: " + e.getMessage());
        }
        System.out.println("after Catch");
        
    }
}
