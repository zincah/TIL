package org.example.effective.chapter9.item57;

/**
 * 아이템 57 : 지역 변수의 범위를 최소화하라
 * - 지역 변수는 사용하는 범위가 짧을수록 코드가 더 읽기 쉽고 유지보수가 쉬워진다.
 *
 * 📌 왜 지역 변수의 범위를 최소화해야 할까?
 * 1) 가독성 향상
 * → 변수를 사용하는 곳 근처에 선언하면 읽기 쉽고 의도를 파악하기 좋다.
 * 2) 코드 오류 감소
 * → 사용되지 않는 변수, 잘못된 변수 재사용 등의 오류를 막을 수 있다.
 * 3) 유지보수 용이성
 * → 변수가 한정된 범위에만 존재하므로 코드 수정 시 영향을 받는 범위가 좁다.
 */
public class VariableScopeGoodExample {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};

        // 변수 사용 시점에 맞춰서 선언
        int sum = 0;  // 합계를 계산하는 변수

        // i : 원소와 반복자의 유효 범위가 반복문 종료와 함께 끝나기때문에 while보다 for문을 추천
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];  // sum은 루프 내에서만 사용됨
        }

        System.out.println("총합: " + sum);

        // 다른 목적의 변수를 새로 선언 (재사용 X)
        String resultMessage = (sum > 20) ? "20보다 큽니다." : "20 이하입니다.";
        System.out.println(resultMessage);
    }

}
