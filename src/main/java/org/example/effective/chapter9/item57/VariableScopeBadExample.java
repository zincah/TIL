package org.example.effective.chapter9.item57;

public class VariableScopeBadExample {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};

        int sum = 0;
        int i = 0;           // 루프 변수 i를 미리 선언해둠 (불필요하게 범위 넓음)
        String message = ""; // 나중에 쓸 변수지만 미리 선언함

        for (i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        if (sum > 20) {
            message = "20보다 큽니다.";
        } else {
            message = "20 이하입니다.";
        }

        System.out.println("총합: " + sum);
        System.out.println(message);
    }

}
