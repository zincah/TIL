package org.example.effective.chapter2.item1;

public class CallMessageSender {

    /**
     * 정적 팩토리 메서드 예시
     * 1. 생성자 대신 of() 사용함으로써 가독성이 좋고 의미가 분명 (이름이 생긴다는 첫번째 장점)
     * 2. 구현 클래스를 클라이언트가 알지않아도 됨
     * 3. 인터페이스로 반환하기에 변경에 대해 유연함 (반환 타입)
     * 4. 다른 패턴을 확장시키기에 좋음
     * 5. of() <-- 정적 팩터리 메서드 작업시점에는 반환할 객체가 없어도 상관 없음.
     */
    public static void main(String[] args) {
        MessageSender sender = MessageSenderFactory.of("sms");
        sender.send("010-1234-5678", "hi");

        MessageSender sender2 = MessageSenderFactory.of("email");
        sender2.send("abcd999@naver.com", "hello");
    }
}
