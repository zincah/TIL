package org.example.effective.chapter10.item76;

import java.util.*;

/**
 * item 76 : 가능한 한 실패 원자적으로 만들라
 * 실패 원자적이란 메서드가 예외를 던져 실패하더라도, 객체의 상태는 호출하기 전과 완전히 동일해야한다는 뜻
 * - 실패해도 부작용이 없고 객체가 일관된 상태를 유지해야한다는 원칙
 *
 * 실패 원자성을 달성하는 방법 4가지
 * - 불변 객체 사용 : 예외 발생 시 기존 객체는 전혀 영향을 받지 않음으로 실패 원자성 보장
 * - 상태 변경 전 유효성 검사 방식
 * - 스냅샷 방식
 * - 실패 원자성을 가진 stack으로 개선
 */
public class FailurAtomicExamples {

    // 1. 불변 객체 사용
    public static final class ImmutablePoint{

        // final 필드를 가진 불변 객체는 내부 상태가 변하지 않음
        private final int x;
        private final int y;

        public ImmutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 변경 대신 새로운 객체 반환
        public ImmutablePoint move(int dx, int dy){

            // 1. 원본 객체(this)는 변경되지 않음
            // 2. 내부 필드는 final 이라 변경 자체가 불가능
            // 3. 예외가 발생하면 새로운 객체 생성이 실패할 뿐 기존 객체는 완벽하게 안전
            return new ImmutablePoint(x+dx, y+dy);
        }
    }

    // 2. 상태 변경 전 유효성 검사 방식
    public static class Person{
        private int age;

        public void setAge(int age){
            if(age < 0){
                throw new IllegalArgumentException("나이는 음수가 아닙니다.");
            }

            this.age = age;
        }
    }

    // 3. 스냅샷 방식 (copy-and-commit)
    public static class SnapshotList<E>{
        private List<E> elements = new ArrayList<>();

        public void addAllSafe(Collection<E> c){
            // 상태 변경 전 임시 복사본에서 작업 수행
            List<E> snapshot = new ArrayList<>(elements);

            try{
                snapshot.addAll(c); // 복사본에서 먼저 작업
                elements = snapshot; // 성공하면 실제 상태 반영
            }catch(Exception e){
                // 기존 상태 영향 없음
                throw e;
            }
        }

        public List<E> getElements(){
            // Collections.unmodifiableList : 해당 리스트의 읽기 전용 뷰
            // return elements; (외부에서 elements.add() 해버릴 수 있음)
            return Collections.unmodifiableList(elements);
        }
    }

    // 4-1. 실패 원자성이 없는 Stack 구현
    public static class BadStack {
        private Object[] elements = new Object[16];
        private int size = 0;

        public void push(Object e) {
            elements[size++] = e;
        }

        public Object pop() {
            Object result = elements[--size]; // size를 먼저 줄임
            elements[size] = null;
            return result;
        }
    }

    // 4-2. 실패 원자성이 있는 Stack 개선 예제
    public static class GoodStack {
        private Object[] elements = new Object[16];
        private int size = 0;

        public void push(Object e) {
            elements[size++] = e;
        }

        public Object pop() {
            if(size == 0){
                throw new EmptyStackException();
            }

            int newSize = size - 1;
            Object result = elements[newSize];
            elements[newSize] = null;
            size = newSize;

            return result;
        }


    }

    public static void main(String[] args) {
        // 1. 불변 객체 테스트
        ImmutablePoint p = new ImmutablePoint(1,2);
        ImmutablePoint moved = p.move(3,4);
        System.out.println("Immutable moved point : (" + moved.x + ", " + moved.y + ")");

        // 2. 유효성 검사
        try{
            Person person = new Person();
//            person.setAge(-10);
            person.setAge(20);
            System.out.println("Person age : " + person.age);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // 3. 스냅샷 방식 테스트
        SnapshotList<String> list = new SnapshotList<>();
        list.addAllSafe(Arrays.asList("a", "b", "c"));
        System.out.println("SnapshotList list : " + list.getElements());

        try{
            list.getElements().add("d");
        }catch (Exception e){
            // java.lang.UnsupportedOperationException 발생
            System.out.println(e.toString());
        }

        // 4-1. 실패 원자성 없는 pop()
        BadStack badStack = new BadStack();
        badStack.push("a");

        // 4-2. 실패 원자성 있는 pop()
        GoodStack goodStack = new GoodStack();
        goodStack.push("a");
        System.out.println("Good pop() : " + goodStack.pop());
    }


}
