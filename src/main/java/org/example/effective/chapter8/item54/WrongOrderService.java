package org.example.effective.chapter8.item54;

import java.util.List;

public class WrongOrderService {
    public static void main(String[] args) {
        WrongOrderService service = new WrongOrderService();
        List<String> items = service.getOrderItems("unknown");

        // null 체크를 강제해야 함. 매우 안좋은 상황
        if (items != null) {
            for (String item : items) {
                System.out.println(item);
            }
        }
    }
    public List<String> getOrderItems(String userId) {
        if (!userExists(userId)) {
            return null; // null 반환 . 매우 안좋은 상황
        }

        // 실제 아이템 목록 로직 (예시 생략)
        return List.of("item1", "item2");
    }

    private boolean userExists(String userId) {
        return !"unknown".equals(userId);
    }
}
