package org.example.effective.chapter8.item54;

import java.util.Collections;
import java.util.List;

//Collections 에는 빈콜렉션을 반환하는 함수가 있다. 이 객체는 싱글턴이기 때문에 다수의 빈 배열이 생기는 경우 성능 저하 이슈를 해결 할 수 있다.

public class GoodOrderService {
    public static void main(String[] args) {
        GoodOrderService service = new GoodOrderService();
        List<String> items = service.getOrderItems("unknown");

        //안전하게 바로 사용 가능 (null 체크 불필요)
        for (String item : items) {
            System.out.println(item);
        }
    }

    public List<String> getOrderItems(String userId) {
        if (!userExists(userId)) {
            return Collections.emptyList(); // 빈 리스트 반환. Collections.emptyList()는 불변이면서 성능도 좋음 (싱글턴 사용).
        }

        return List.of("item1", "item2");
    }

    private boolean userExists(String userId) {
        return !"unknown".equals(userId);
    }
}
