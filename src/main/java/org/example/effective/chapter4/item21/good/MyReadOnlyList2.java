package org.example.effective.chapter4.item21.good;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 자바 플랫폼에서의 예방 조치 - 예방 케이스
 *
 * 디폴트 메서드로 인해 생길 수 있는 예상치 못한 동작을 직접 오버라이드해서 막음으로써
 * 작성자의 의도를 코드 수준에서 분명히 함
 *
 * 디폴트 메서드는 기본 기능을 제공해 주지만,
 * 기존 구현이 해당 기능을 원하지 않거나 금지해야 하는 경우,
 * 직접 오버라이드해서 명시적으로 차단하거나, 필요한 보완을 해줘야 한다.
 *
 * --> 인터페이스 설계자와 구현자 모두가 고려해야 할 설계 수칙
 */
public class MyReadOnlyList2<E> extends ArrayList<E> {
    private final List<E> internalList;
    public MyReadOnlyList2(List<E> list){
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

    // ✅ 디폴트 메서드를 명시적으로 무력화
    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException("Read-only");
    }
}
