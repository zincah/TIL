package org.example.effective.chapter4.item20.helper;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * 우회 사용 방식 : 골격 클래스를 상속하지 않더라도,
 * 내부에서 그것을 도와주는 헬퍼 객체처럼 써서
 * 공통 기능은 그대로 활용하고, 바깥에서는 인터페이스만 보이게 할 수 있다.
 *
 * 우회적으로 사용하는 이유 ?
 * - 이미 다른 클래스 상속하고 있을때
 * - 캡슐화와 역할 분리를 더 철저히 하고 싶을때
 * - API에서 골격 클래스가 노출되지 않게 하려고 할때
 *
 * 예제
 * - MyQueue는 Collection만 직접 구현
 * - AbstractCollection을 상속한 건 private 내부 클래스.
 * - 내부 클래스는 공통 기능을 대신 구현하고, MyQueue는 그 기능을 위임받아 사용.
 * - 외부에서는 AbstractCollection이 사용된 줄도 모름 (캡슐화)
 */
public class MyQueue<E> implements Collection<E> {

    private final Collection<E> helper;
    public MyQueue(){
        helper = new MyQueueSkeleton(); // 내부 구현 객체
    }

    // 내부 클래스에서 골격 구현 클래스 확장
    private class MyQueueSkeleton extends AbstractCollection<E>{
        private final java.util.Queue<E> data = new java.util.LinkedList<>();

        // 아래의 메서드들은 로직 상 제정의해야할 부분이므로 내부 클래스에서 오버라이딩해서 구현
        @Override
        public Iterator<E> iterator() {
            return data.iterator();
        }

        @Override
        public int size() {
            return data.size();
        }

        @Override
        public boolean add(E e) {
            return data.add(e);
        }
    }

    // 위임: MyQueue는 Collection이지만 실제 구현은 helper가 담당
    // -> 실제 동작은 helper(MyQueueSkeleton)가 처리함
    @Override public int size() { return helper.size(); }
    @Override public boolean isEmpty() { return helper.isEmpty(); }
    @Override public boolean contains(Object o) { return helper.contains(o); }
    @Override public Iterator<E> iterator() { return helper.iterator(); }
    @Override public Object[] toArray() { return helper.toArray(); }
    @Override public <T> T[] toArray(T[] a) { return helper.toArray(a); }
    @Override public boolean add(E e) { return helper.add(e); }
    @Override public boolean remove(Object o) { return helper.remove(o); }
    @Override public boolean containsAll(Collection<?> c) { return helper.containsAll(c); }
    @Override public boolean addAll(Collection<? extends E> c) { return helper.addAll(c); }
    @Override public boolean removeAll(Collection<?> c) { return helper.removeAll(c); }
    @Override public boolean retainAll(Collection<?> c) { return helper.retainAll(c); }
    @Override public void clear() { helper.clear(); }
}
