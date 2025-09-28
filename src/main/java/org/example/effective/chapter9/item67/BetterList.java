package org.example.effective.chapter9.item67;

import java.util.List;

/**
 * 컴포시젼 (유연한 성능 교체 가능 예제)
 *
 * - 내부에 list를 두고 위임하는 구조
 * - ArrayList -> LinkedList 등으로 교체 가능
 * - 외부 API는 변하지 않으므로, 성능 최적화의 자유를 가진다.
 *
 * 즉, 상속은 기능 재사용에는 편리하지만, 성능까지 상속하기 때문에
 * 컴포지션을 사용해 성능 문제 발생 시 내부 구현만 교체하면 되므로 최적화에 유리
 */
public class BetterList<E> {
    private final List<E> list;

    public BetterList(List<E> list) {
        this.list = list;
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public boolean add(E e){
        return list.add(e);
    }

    public int size(){
        return list.size();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
