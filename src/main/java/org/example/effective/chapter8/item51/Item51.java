package org.example.effective.chapter8.item51;

/**
 * 메서드 시그니처를 신중히 설계하라
 * 1. 메서드 이름을 신중히 짓자
 * 2. 편의 메서드를 너무 많이 만들지 말자.
 * 3. 매개변수 목록은 짧게 유지하자. (4개 이하 권장)
 *  매개변수가 긴 경우
 *  a. 여러 메서드로 쪼갠다.
 *  b. 매개변수 여러 개를 묶어주는 도우미 클래스를 만든다.
 *  c. 객체 생성에 사용한 빌더 패턴을 응용한다.
 *  매개변수의 타입으로는 클래스보다는 인터페이스가 낫다.
 */
public class Item51 {

    public static void main(String[] args) {

        // 너무 긴 매개변수
        BadOrderProcessor badOP = new BadOrderProcessor();
        badOP.processOrder(
                "user001",
                "itemA123",
                2,
                "서울특별시 강남구",
                "카드"
        );

        // 도우미 클래스
        OrderRequest orderRequest = new OrderRequest(
                "user001",
                "itemA123",
                2,
                "서울특별시 강남구",
                "카드"
        );
        GoodOrderProcessor goodOP = new GoodOrderProcessor();
        goodOP.processOrder(orderRequest);

        // 빌더 패턴
        OrderRequest order = new OrderRequestBuilder()
                .userId("user001")
                .itemId("itemA123")
                .quantity(2)
                .shippingAddress("서울특별시 강남구")
                .paymentMethod("카드")
                .build();

        GoodOrderProcessor processor = new GoodOrderProcessor();
        processor.processOrder(order);
    }
}
