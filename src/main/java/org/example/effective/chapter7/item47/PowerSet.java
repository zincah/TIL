package org.example.effective.chapter7.item47;

import java.util.*;

/**
 * 멱집합: 한 집합의 모든 부분집합
 * 원소 개수가 n개이면 멱집합의 원소 개수는 2^n개
 *  -> 표준 컬렉션 구현체에 저장하려는 생각은 위험
 *
 *  멱집합을 구성하는 각 원소의 인덱스를 비트 벡터로 사용(1: 포함, 0: 미포함)
 *  (a, b, c) -> 000 ~ 111
 */
public class PowerSet {
    public static void main(String[] args) {

    }

    public static final <E>Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);

        if (src.size() > 30)
            throw new IllegalArgumentException(
                    "집합에 원소가 너무 많습니다.(최대 30개).: " + s
            );

        return new AbstractList<Set<E>>() {
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; index >>= 1)
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }

            @Override
            public int size() {
                // 멱집합의 크기는 2를 원래 집합의 원소 수만큼 거듭제곱
                return 1 << src.size();
            }

            @Override public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }
        };
    }
}
