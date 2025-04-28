package org.example.effective.item7_eliminatereferences;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter2.item7.SoftCache;
import org.junit.jupiter.api.Test;

@Slf4j
public class SoftCacheTest {

    @Test
    public void softCache(){
        SoftCache cache = new SoftCache();

        for (int i = 0; i < 10_000; i++) {
            cache.put("key" + i, new byte[1024 * 100]); // 100KB씩
        }

        log.debug("캐시 크기: " + cache.size());

        System.gc(); // 메모리 부족 유도 (보장 X)

        log.debug("캐시 크기: " + cache.size());
    }
}
