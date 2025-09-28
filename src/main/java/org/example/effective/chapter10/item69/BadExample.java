package org.example.effective.chapter10.item69;

/**
 * 아이템69 : 예외는 진짜 예외 상황에만 사용하라
 *
 * - 예외(Exception)는 이름 그대로 “예외적 상황(정상적인 흐름에서 벗어난 상황)”에서만 사용해야 한다.
 * - 정상적인 제어 흐름(control flow)을 위해 예외를 쓰면 성능도 나쁘고, 가독성/유지보수성도 크게 떨어진다.
 * - 예외 = 오류 처리용 / 일반적인 흐름 = 조건문, 반환값, Optional 등으로 처리
 *
 * 예외를 정상적인 제어흐름에 사용하면 문제가 되는 이유
 * 1) 성능 문제
 * 예외는 생성 시 스택 트레이스 캡처, 객체 생성 등 큰 비용이 든다.
 * 루프에서 예외를 제어문처럼 사용하면 심각한 성능 저하 발생.
 *
 * 2) 가독성/의도 불명확
 * 코드만 봐서는 “정상 흐름”인지, “진짜 예외 상황”인지 헷갈린다.
 * API 사용자도 오해할 수 있다.
 */
public class BadExample {

    public static void main(String[] args) {
        // ❌ 배열의 끝에 도달할 때까지 예외로 루프를 제어하는 나쁜 예시
        int[] numbers = {1, 2, 3, 4, 5};
        try {
            int i = 0;
            while (true) {
                System.out.println(numbers[i++]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // 루프 종료 시점 → 예외로 제어 흐름을 종료
            System.out.println("배열 끝!");
        }
    }
}
