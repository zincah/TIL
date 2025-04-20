package org.example.effective.item7_eliminatereferences;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class WeakCacheTest {

    @Test
    public void weakCache() throws InterruptedException{
        WeakCache cache = new WeakCache();

        Object key1 = new Object();
        Object key2 = new Object();

        cache.put(key1, "value1");
        cache.put(key2, "value2");

        log.debug("초기 캐시 크기 : {}", cache.size());

        key1 = null;

        log.debug("null 처리 이후 캐시 크기 : {}", cache.size());

        System.gc();
        Thread.sleep(1000);

        log.debug("gc 이후 캐시 크기 : {}", cache.size());
    }
}
