package org.example.effective.chapter5.item33;

import java.util.HashMap;
import java.util.Map;

/**
 * 이종 컨테이너 heterogeneous container
 * - 서로 다른 타입의 객체들을 하나의 컨테이너에 저장할 수 있도록 만들되,
 * 꺼낼 때는 타입 안정성(type safety)을 보장하는 컨테이너
 *
 * “Class 리터럴(Class<T>)”을 타입 키로 사용하는 패턴
 */
public class Item33 {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();

        // 서로 다른 타입의 값 저장
        favorites.putFavorite(String.class, "Java");
        favorites.putFavorite(Integer.class, 2024);
        favorites.putFavorite(Boolean.class, Boolean.TRUE);

        // 타입 안전하게 꺼내기
        String favoriteString = favorites.getFavorite(String.class);
        Integer favoriteInteger = favorites.getFavorite(Integer.class);
        Boolean favoriteBoolean = favorites.getFavorite(Boolean.class);

        System.out.println("String: " + favoriteString);
        System.out.println("Integer: " + favoriteInteger);
        System.out.println("Boolean: " + favoriteBoolean);
    }
}

class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    // 타입 키와 값 저장
    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) throw new NullPointerException("Type is null");
        favorites.put(type, instance);
    }

    // 타입 키로 값 조회 및 캐스팅 → 타입 안전
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type)); // 안전한 강제 형변환 (Class<T>의 cast 메서드 사용)
    }
}
