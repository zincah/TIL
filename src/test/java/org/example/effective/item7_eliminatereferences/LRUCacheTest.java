package org.example.effective.item7_eliminatereferences;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LRUCacheTest {

    @Test
    public void lruCache(){
        LRUCache<String, String> cache = new LRUCache<>(3);

        cache.put("a", "apple");
        cache.put("b", "banana");
        cache.put("c", "cherry");

        log.debug("초기: " + cache.keySet());

        cache.get("a"); // a를 최근에 사용
        cache.put("d", "date"); // b가 제거됨

        log.debug("최종: " + cache.keySet());
    }
}
