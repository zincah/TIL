package org.example.effective.chapter7.item43;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * 람다로 구현했을때 너무 길거나 복잡하다면 메서드 참조가 좋은 대안
 * -> 람다로 작설할 코드를 새로우 ㄴ메서드에 담은 후, 람다 대신 그 메서드 참조를 사용
 */
public class Main {
    public static void main(String[] args) {
        staticMethodReference();
        System.out.println("--------------------------------------");
        boundInstanceMethodReference();
        System.out.println("--------------------------------------");
        unboundInstanceMethodReference();
        System.out.println("--------------------------------------");
        classConstructorReference();
        arrayConstructureReference();
    }

    /**
     * 1. 정적 메소드 참조
     * 클래스의 정적 메서드를 참조할 때 사용
     */
    public static void staticMethodReference() {
        //람다
        Function<String, Integer> parseInteger1 = s -> Integer.parseInt(s);
        System.out.println(parseInteger1.apply("123").getClass().getName());

        //메서드참조
        Function<String, Integer> parseInteger2 = Integer::parseInt;
        System.out.println(parseInteger2.apply("123").getClass().getName());

    }

    /**
     * 2. 한정적 인스턴스 메서드 참조
     * 특정 객체의 인스턴스 메서드를 참조할 때 사용
     */
    public static void boundInstanceMethodReference() {
        String prefix = "LOG: ";

        // 람다
        Consumer<String> log1 = msg -> System.out.println(prefix + msg);
        log1.accept(prefix + "Hello lambda");

        // 메서드 참조
        PrintStream out = System.out;
        Consumer<String> log2 = out::println;  // out은 "한정된 객체"
        log1.accept(prefix + "Hello method reference");

    }

    /**
     * 3. 비한정적 인스턴스 메서드 참조
     * 객체가 아직 정해지지 않은 상태에서, 클래스의 인스턴스 메서드를 참조할 때 사용.
     * 첫 번째 매개변수가 대상이 됨
     */
    public static void unboundInstanceMethodReference() {
        // Comparator 람다
        Comparator<String> cmp1 = (s1, s2) -> s1.compareToIgnoreCase(s2);
        System.out.println(cmp1.compare("a", "b"));

        // 메서드 참조
        Comparator<String> cmp2 = String::compareToIgnoreCase;
        System.out.println(cmp1.compare("a", "b")); // "a".compareToIgnoreCase("b")
    }

    /**
     * 4. 클래스 생성자 참조
     * new Class() 같은 생성자 호출을 참조하는 방식
     */
    public static void classConstructorReference() {
        // 람다
        Supplier<List<String>> newList1 = () -> new ArrayList<>();
        List<String> list1 = newList1.get();
        // 메서드 참조
        Supplier<List<String>> newList2 = ArrayList::new;
        List<String> list2 = newList2.get();
    }

    /**
     * 배열 생성자 참조
     * 배열을 생성하는 것도 메서드 참조로 가능함
     */
    public static void arrayConstructureReference() {
        // String[] 타입 배열 생성 람다
        IntFunction<String[]> array1 = size -> new String[size];
        String[] strArray1 = array1.apply(10);
        // 메서드 참조
        IntFunction<String[]> array2 = String[]::new;
        String[] strArray2 = array2.apply(10);
    }


}

