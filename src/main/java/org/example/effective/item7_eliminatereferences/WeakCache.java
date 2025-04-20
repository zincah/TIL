package org.example.effective.item7_eliminatereferences;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * item7 : 다 쓴 객체 참조를 해제하라
 * 참조를 유지하면 gc 대상이 되지 않아서 메모리를 차지하게되며 메모리 누수 발생
 * ## 참조를 제거해야하는 법 ##
 * - 컬렉션에 담은 객체 : 사용 후 꼭 remove() 또는 clear()
 * - 캐시 : 적적한 만료 정책 사용
 * - 이벤트 리스너 : 해제하지 않으면 리스너 객체도 gc 대상에서 제외
 * 아래의 예제들은 메모리 누수 방지 캐시 예제를 작성
 * **/

/**
 * WeakHashMap : 키 객체가 더 이상 참조되지 않으면 자동으로 제거되는 캐시를 만들 때 적합
 * 약한 참조 기반 캐시 (WeakHashMap을 사용하여 Weak Reference Cache) 패턴 사용
 */
public class WeakCache {

    private final Map<Object, String> cache = new WeakHashMap<>();

    public void put(Object key, String value){
        cache.put(key, value);
    }

    public String get(Object key){
        return cache.get(key);
    }

    public int size(){
        return cache.size();
    }
}
