package org.example.effective.chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;

// 제네릭 스택 클래스 (간략화)
class GoodStack<E> {
    private final List<E> elements = new ArrayList<>();

    public void push(E e) {
        elements.add(e);
    }

    public E pop() {
        if (elements.isEmpty()) throw new EmptyStackException();
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // 한정적 와일드카드 사용!
    // pushAll: 생성을 위한 '생산자'이므로 <? extends E>
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) push(e);
    }

    // popAll: 소비자를 위한 '소비자'이므로 <? super E>
    // E의 collection이 아닌 E의 상위 타입의 Collection
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
}