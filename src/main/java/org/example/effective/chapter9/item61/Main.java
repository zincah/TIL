package org.example.effective.chapter9.item61;

import java.util.Comparator;

/**
 * 박싱 타입 보다는 기본 타입을 사용해야한다.
 * <p>
 * 차이점
 * 1. 식별성: 박싱 타입과 기본 타입은 두 값이 같아도 다르다고 식별할 수 있다.
 * 2. null 가능여부: 기본타입은 null 불가능. 박싱타입은 null 가능
 * 3. 성능: 기본타입이 메모리 사용면에서 효율적
 *
 *
 * 적절히 사용하는 방법
 * 1. 컬렉션의 원소, 키, 값으로 사용
 * 2. 제네릭 타입과 함께 사용
 * 3. 리플렉션 API 사용시 (item 65)
 */
public class Main {

    static Integer boxingIdx ;
    static int idx;

    public static void main(String[] args) {
         //* 1. 식별성: 박싱 타입과 기본 타입은 두 값이 같아도 다르다고 식별할 수 있다.
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
        System.out.println(naturalOrder.compare(42, 42)); // 0 출력
//        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42))); // 1 출력, 첫번째 Integer가 두번째 보다 큼
        // i < j 는 정상 작동. 그러나 i==j에서 두 객체의 instance 식별성을 검사. 값이 같으나 두 인스턴스가 다르기 때문에 false 반환


        // * 2. null 가능여부: 기본타입은 null 불가능. 박싱타입은 null 가능
        try {
            if (boxingIdx == 42) {
                System.out.println("믿을 수 없군");
            }
        } catch (NullPointerException e) {
            System.out.println("NULL POINTER EXCEPTION");
        }
        if( idx == 0) {
            // 기본타입은 기본값 0
            System.out.println("idx is 0");
        }

        //* 3. 성능: 기본타입이 메모리 사용면에서 효율적
        // 박싱과 언박싱이 계속 반복하기때문에 느림
        Long sum = 0L;
        long startTime = System.currentTimeMillis();
        for(long i = 0 ; i < Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - startTime + " milli sec, " +sum);

        long sum2 = 0L;
        long startTime2= System.currentTimeMillis();
        for(long i = 0 ; i < Integer.MAX_VALUE; i++){
            sum2 += i;
        }
        System.out.println(System.currentTimeMillis() - startTime2 + " milli sec, " +sum2);
    }

}
