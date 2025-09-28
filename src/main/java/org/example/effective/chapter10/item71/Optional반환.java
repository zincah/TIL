package org.example.effective.chapter10.item71;

import java.util.Optional;

class GoodQueue_B {
    private final java.util.List<String> elements = new java.util.ArrayList<>();

    // Optional을 반환하여 값이 없을 가능성을 명시적으로 알림
    public Optional<String> poll() { // 보통 Optional 반환 시 poll()을 사용
        if (elements.isEmpty()) {
            return Optional.empty(); // 비어있음을 명시적으로 반환
        }
        return Optional.of(elements.remove(0));
    }
    // ... add 메서드 생략 ...
}

public class Optional반환 {
    public static void processData(GoodQueue_B queue) {
        // Optional의 메서드를 사용해 흐름 제어
        queue.poll().ifPresentOrElse(
                item -> System.out.println("처리: " + item), // 값이 있을 경우
                () -> System.out.println("(Good B) 큐가 비어서 작업을 건너뜁니다. (Optional 사용)") // 값이 없을 경우
        );
        // 코드가 간결하고, '값이 없을 경우'를 절대 놓치지 않습니다.
    }

    public static void main(String[] args) {
        processData(new GoodQueue_B());
    }
}

