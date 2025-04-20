package org.example.effective.item7_eliminatereferences;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * SoftReference 기반 캐시
 * - 메모리가 부족할때만 gc 가 수거
 * - 사용자 경험이 중요한 이미지 캐시나 성능을 위해 가능한 오래 유지하고 싶은 캐시에 적합
 */
public class SoftCache {
    private final Map<String, SoftReference<Object>> cache = new HashMap<>();

    public void put(String key, Object value) {
        cache.put(key, new SoftReference<>(value));
    }

    public Object get(String key) {
        SoftReference<Object> ref = cache.get(key);
        return (ref != null) ? ref.get() : null;
    }

    public int size() {
        return cache.size();
    }
}
