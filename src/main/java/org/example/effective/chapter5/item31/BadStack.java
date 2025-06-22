package org.example.effective.chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;

// 제네릭 스택 클래스 (간략화)
class BadStack<E> {
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

    // 잘못된 버전 (타입 제한으로 유연성 ↓):
    public void pushAll(Iterable<E> src) {
        for (E e : src) push(e);
    }

    public void popAll(Collection<E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
}