package org.example.effective.chapter9.item67;

import java.util.ArrayList;

/**
 * 아이템 67 : 최적화는 신중히 하라
 * - 최적화는 필요할때, 근거를 가지고 최소한으로 하라
 * - 빠른 프로그램 보다 좋은 프로그램이 더 중요하다.
 *
 * 설계 시 고려해야할 점 : 좋은 API, 자료구조의 선택은 나중에 성능을 위해 쉽게 개선할 수 있는 토대가 된다.
 * --> 상속과 컴포지션의 설계 방식 차이가 성능 제약과 어떻게 연결되는지 보여주는 예제
 * (나중에 성능을 끌어올릴 수 있는 여지를 남겨둬라라는 뜻)
 */
public class SlowList<E> extends ArrayList<E> {

    /**
     * SlowList는 ArrayList의 성능 제약을 그대로 받는다.
     * 더 효율적인 자료구조(HashSet등등)으로 바꾸고 싶어도 불가능하다.
     * API가 ArrayList를 상속받아 공개된 이상, 성능 문제를 영원히 떠안는다.
     */
    @Override
    public boolean contains(Object o) {

        // 성능이 좋지 않은 contains를 상속받았다고 가정
        return super.contains(o);
    }
}
