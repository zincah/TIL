package org.example.effective.chapter10.item71;

class GoodQueue_A {
    private final java.util.List<String> elements = new java.util.ArrayList<>();

    // 상태 검사 메서드 제공 (isEmpty())
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // 큐가 비었을 경우 런타임 예외를 던짐 (프로그래밍 오류로 간주)
    // 호출자가 isEmpty()를 먼저 호출하지 않은 것은 '계약 위반'으로 간주.
    public String remove() {
        if (elements.isEmpty()) {
            // 런타임 예외 (Unchecked Exception) 사용
            throw new java.util.NoSuchElementException("큐가 비어있습니다.");
        }
        return elements.remove(0);
    }
    // ... add 메서드 생략 ...
}

public class Test메서드제공 {
    public static void processData(GoodQueue_A queue) {
        // 상태 검사 메서드를 사용하여 예외 없이 깔끔하게 처리
        if (!queue.isEmpty()) {
            String item = queue.remove();
            System.out.println("처리: " + item);
        } else {
            System.out.println("(Good A) 큐가 비어서 작업을 건너뜁니다. (예외 없음)");
        }
        // 코드가 훨씬 간결하고 가독성이 좋습니다.
    }
    public static void main(String[] args) {

        GoodQueue_A queue = new GoodQueue_A();
        processData(queue);
    }
}