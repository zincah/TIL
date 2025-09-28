package org.example.effective.chapter10.item71;

// 1. (가정) 큐가 비었을 때 던지는 검사 예외
class EmptyQueueException extends Exception {
    public EmptyQueueException(String message) {
        super(message);
    }
}

class BadQueue {
    private final java.util.List<String> elements = new java.util.ArrayList<>();

    // 검사 예외를 던지는 메서드 (호출자에게 try-catch 강제)
    public String remove() throws EmptyQueueException {
        if (elements.isEmpty()) {
            throw new EmptyQueueException("큐가 비어있습니다.");
        }
        return elements.remove(0);
    }
}

public class 나쁜방법 {
    public static void processData(BadQueue queue) {
        // 호출자는 큐를 사용할 때마다 try-catch를 써야 합니다.
        try {
            String item = queue.remove();
            System.out.println("처리: " + item);
        } catch (EmptyQueueException e) {
            // EmptyQueueException를 강제로 처리해야하기 때문에 코드가 복잡해짐
            System.out.println("(Bad) 큐가 비어서 작업을 건너뜁니다.");
        }
    }

    public static void main(String[] args) {
        processData(new BadQueue());
    }
}