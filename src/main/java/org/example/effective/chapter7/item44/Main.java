package org.example.effective.chapter7.item44;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntBiFunction;

/**
 * 람다를 쓰기 위해선 단 하나의 추상 메서드만 가진 인터페이스, 즉 함수형 인터페이스가 필요
 * 자바는 java.util.function 패키지에 여러 표줌 함수형 인터페이스를 정의해 놓음
 * 따라서 불 필요하게 직접 정의할 필요 없음
 * <p>
 * 대표 함수형 인터페이스: 함수를 변수처럼 인자로 넘길 수 있도록 함
 * Function<T,R> T:입력 타입, R출력 타입
 * Consumer<T> : T를 받아서 처리, 반환 X
 * Supplier<T>: 인자값 없음, T반환
 * Predicate<T>: T를 받아서 boolean 타입 반환
 * UnaryOperator<T>: T를 받아서 T 반환
 * BinaryOperator<T>: 두개의 T를 받아서 T를 반환
 * <p>
 * <p>
 * 대표 함수형 인터페이스에 int,double,long 이 붙은 변형
 * * IntConsumer: int 전용 consumer, 박싱(Integer)을 피하기 위함. Consumer<Integer>보다 GC 부담을 줄임
 * * LongFunction<R>: long -> R로 반환하는 함수
 * ... 등등
 * <p>
 * -- 대표적인 추가 함수형 인터페이스
 * BiConsumer<T,U>: T,U 둘다 인자값으로 사용, 반환 없음. 흔히 Mpa 처리, 키-값 쌍 처리에 사용
 * <p>
 * 변형 Function: SrcToResult를 접두어로 사용, 또는 접두어로 ToResult 사용
 * - IntToLongFunction (int를 받아 long 으로 반환) 등..
 * - ToLongFunction<int[]>(int[]를  long 으로 반환) 등..
 */


public class Main {
    public static void main(String[] args) {

        // 1. 기본 함수형 인터페이스에 박싱된 기본 타입을 사용하면 느리다
        boxingExample();

        // 2. Comparator<T> 인터페이스 처럼 ToIntBiFunction<T,U>가 존재하지만 Comparator를 사용하는 경우
        ComparatorExample();

        // 3. 직접 만든 함수형 인터페이스 항상 @FunctionalInterface 애너테이션을 사용
        customInterfaceExample();
    }

    public static void boxingExample() {
        int loop = 100_000_000;

        // 박싱된 함수
        Function<Integer, Integer> boxed = x -> x + 1;

        // 기본형 함수
        IntUnaryOperator primitive = x -> x + 1;

        // 박싱된 함수 성능 측정
        long start1 = System.nanoTime();
        int sum1 = 0;
        for (int i = 0; i < loop; i++) {
            sum1 += boxed.apply(i);  // 여기서 박싱 발생
        }
        long end1 = System.nanoTime();
        System.out.println("Boxed Function:   " + (end1 - start1) / 1_000_000 + " ms");

        // 기본형 함수 성능 측정
        long start2 = System.nanoTime();
        int sum2 = 0;
        for (int i = 0; i < loop; i++) {
            sum2 += primitive.applyAsInt(i);  // 박싱 없음
        }
        long end2 = System.nanoTime();
        System.out.println("Primitive Function: " + (end2 - start2) / 1_000_000 + " ms");

        // 결과 확인용
        System.out.println("Sum1 = " + sum1 + ", Sum2 = " + sum2);
    }

    /////////////////////////////////////
    public static void ComparatorExample() {
        Person p1 = new Person("Kim", 30);
        Person p2 = new Person("Lee", 25);

        // 비표준 방식 (ToIntBiFunction 사용)
        ToIntBiFunction<Person, Person> ageDiff = (a, b) -> a.age - b.age;

        // 표준 방식 (Comparator 사용)
        Comparator<Person> comparator = Comparator.comparingInt(p -> p.age);

        /**
         * 기본 함수형 인터페이스도 사용 가능 하지만 전용 함수형 인턴페이스를 사용하려면 진중히 고민해야함
         * - 자주 쓰이며, 이름 자체가 용도를 명확히 설명해야함
         * - 반드시 따라야 하는 규약이 있다
         *  - 유용한 디폴트 메서드를 제공할 수 있다.
         */

        System.out.println("나이 차이 (비표준): " + ageDiff.applyAsInt(p1, p2));
        System.out.println("나이 비교 (표준): " + comparator.compare(p1, p2));
    }
    static class Person {
        String name;
        int age;
        Person(String name, int age) { this.name = name; this.age = age; }
    }


    //////////////////////////////

    public static void customInterfaceExample () {
        StringFilter startsWithA = s -> s.startsWith("A");

        System.out.println(startsWithA.test("Apple"));  // true
        System.out.println(startsWithA.test("Banana")); // false
    }

    @FunctionalInterface
    interface StringFilter {
        boolean test(String input);
    }
}
