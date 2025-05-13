package org.example.effective.chapter4.item21.issue;

import java.util.AbstractList;
import java.util.List;

/**
 * 자바 플랫폼에서의 예방 조치 - 문제 케이스
 *
 * 자바8 부터 Collection, List, Set 같은 주요 인터페이스에 default 메서드가 추가되면서
 * 예상치 못한 충돌이나 버그가 발생할 수 있음
 *
 * 아래의 코드는 default 메서드로 인해 예상치 못한 결과가 발생하는 경우를 작성하였다.
 *
 * Collection.removeIf() -> 자바8부터 default 메서드로 제공
 * 컬렉션 구현체가 이를 고려하지 않고 만든다면 removeIf()가 자동으로 상속되고 예상치 못한 동작 또는 예외 발생
 */
public class MyReadOnlyList<E> extends AbstractList<E> {

    private final List<E> internalList;

    public MyReadOnlyList(List<E> list){
        this.internalList = list;
    }

    @Override
    public E get(int index) {
        return internalList.get(index);
    }

    @Override
    public int size() {
        return internalList.size();
    }

    // 삭제, 삽입은 허용하지 않음
    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Read-only");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Read-only");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Read-only");
    }
}
