package org.example.effective.chapter10.item69;

/**
 * 예외는 흐름 제어를 위한 도구가 아니라, 프로그램이 정상적으로 처리할 수 없는 상황을 보고하기 위한 장치다
 */
public class GoodExample {

    public static void main(String[] args) {
        // ✅ 조건 검사를 통해 정상적인 흐름 제어
        int[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    // 예외처리는 진짜 예외적인 상황에서 사용
    public int parsePort(String input) {
        try {
            int port = Integer.parseInt(input);
            if (port < 0 || port > 65535) {
                throw new IllegalArgumentException("Port out of range: " + port);
            }
            return port;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid port: " + input, e);
        }
    }
}
