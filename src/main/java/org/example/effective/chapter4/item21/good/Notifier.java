package org.example.effective.chapter4.item21.good;

/**
 * 안전하게 디폴트 메서드를 확장하는 3가지 패턴
 * 2. 디폴트 메서드를 만들되, 내부에서 다른 메서드에 위임
 * - 디폴트 메서드 내부에서 오버라이딩 가능한 메서드를 호출하도록 설계
 */
public interface Notifier {
    void send(String message);

    default void sendError(String errorMessage){
        send("[ERROR] " + errorMessage); // send에 위임
    }
}
