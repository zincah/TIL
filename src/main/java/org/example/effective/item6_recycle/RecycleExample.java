package org.example.effective.item6_recycle;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * item6 : 불필요한 객체 생성을 피하라
 * - 라이브러리 메서드가 객체를 매번 새로 만들거라고 추측하면 안된다.
 * 예제) keySet()을 호출할 때마다 Set을 새로 만든다고 생각하면
 * 비용이 크다 또는 Set을 변경했을때 Map에 영향이 없을거라 생각하지만
 * 실제로 Map의 데이터에 직접 연결된 Set을 반환하는 것이다. (뷰)
 */
@Slf4j
public class RecycleExample {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        Set<String> keySet1 = map.keySet();
        Set<String> keySet2 = map.keySet();

        // 새로운 Set을 만들어주는 것처럼 보여도, 뷰(View) 객체를 반환
        log.debug("keySet1 == keySet2 : {}", keySet1 == keySet2);

        keySet1.remove("a"); // map에도 영향
        log.debug("map containsKey a = {}", map.containsKey("a"));
    }
}
