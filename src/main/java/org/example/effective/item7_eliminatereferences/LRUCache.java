package org.example.effective.item7_eliminatereferences;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 기반 LRU 캐시 (Least Recently Used)
 * - 가장 오래 사용되지 않은 항목을 자동으로 제거
 * - 캐시 용량을 제한할 수 있어 메모리 사용량 제어에 적합
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true → LRU
        // 1. initialCapacity : 초기 버킷 수, 해시 테이블 크기를 미리 지정해서 리사이즈 비용을 줄일 수 있음
        // 2. 로그 팩터 (보통 0.75) : 얼마나 채워졌을 때 해시 테이블 크기를 늘릴지 결정
        // 3. true - 최근 접근 순서 (get or put), false - 삽입 순서 유지
        this.capacity = capacity;
    }

    /**
     * 이 메서드는 LinkedHashMap에서 새로운 항목이 추가될 때마다 호출돼서,
     * 가장 오래된 항목(eldest)을 제거할지 여부를 결정하는 데 사용
     *
     * - 기본 구현은 항상 false 반환하여 자동으로 항목 제거 x
     * - 오버라이드해서 true를 반환하게 해주면 true일때, 해당 항목 자동 제거
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
