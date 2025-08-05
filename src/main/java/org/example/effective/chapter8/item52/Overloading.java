package org.example.effective.chapter8.item52;

import java.math.BigInteger;
import java.util.*;

/**
 * 다중정의한 메서드(overloading)는 정적 선택
 * 재정의한 메서드(overriding)는 동적선택
 *
 * 다중 정의된 메서드는 객체의 런타임 타입은 중요하지않음
 * 오직 매개변수의 컴파일 타임 타입에 의해 이루어짐
 *
 * 컴파일 타임 타입: 컴파일 시점의 컴파일러가 알고 있는 타입. 즉 선언한 타입
 * 런타임 타입: 실행 중에 실제 객체의 타입. 진짜 타입
 * Object obj = "hello"; 컴파일 타임 타입은 Object, 런타임 타입은 String
 *
 * 오버로딩 주의점
 * 혼동을 일으키는 호버로딩 상황 피하기
 * 매개변수 수가 같은 오버로딩은 가급적 피해야함
 * 오버로딩 대신 이름을 다르게 줄 수 있음 (writeBoolean, writeInt, writeLong)
 */
public class Overloading {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> s) {
        return "List";
    }

    public static String classify(Collection<?> s) {
        return "else";
    }

    //명시적으로 작성가능
//    public static String classify(Collection<?> s) {
//        return s instanceof Set? "Set" :
//                s instanceof List? "List" : "else";
//    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            //런타입때는 타입이 달라지지만, 어느 메서드를 호출할지는 컴파일 타임에 정해지기 때문에  else만 출력
            System.out.println(classify(c));
        }
        System.out.println("=========================================");
        for (Collection<?> c : collections) {
            if(c instanceof Set) {
                System.out.println(classify((Set<?>)c));
            } else if(c instanceof List) {
                System.out.println(classify((List<?>)c));
            } else {
                System.out.println(classify(c));
            }
        }
    }

}
