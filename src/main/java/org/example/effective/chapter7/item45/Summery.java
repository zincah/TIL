package org.example.effective.chapter7.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Summery {
    public static void main(String[] args) {
        스트림은_간결한_코드에만_적합();
        중첩루프와_복잡한_조건_분기면_피하라();
        스트림은_디버깅과_로깅이_어렵다();
        break_과_continue_는_불가능();
        성능이_항상_더_좋은건_아님();
        무리한_체이닝은_가독성이_떨어짐();
        스트림은_순수_함수_중심의_사고에_적합();
    }

    //간단한 변환(map), 수집(collect)는 스트림이 적절
    public static void 스트림은_간결한_코드에만_적합() {
        List<String> names = List.of("Kim", "Lee", "Park");

        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upper);  // [KIM, LEE, PARK]
    }

    public static void 중첩루프와_복잡한_조건_분기면_피하라() {

        //피해야함
        IntStream.range(0, 3)
                .forEach(i -> IntStream.range(0, 3)
                        .filter(j -> (i + j) % 2 == 0)
                        .forEach(j -> System.out.println(i + ", " + j)));

        //굿
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.println(i + ", " + j);
                }
            }
        }
    }

    public static void 스트림은_디버깅과_로깅이_어렵다() {
        // 가능은 하지만, 람다 내부에 디버깅 코드가 들어가면서 매우 지저분해짐
        // for문은 System.out.println()을 자유롭게 배치할 수 있어 더 깔끔하고 직관적
        List<String> list = List.of("apple", "banana", "cherry");

        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);  // 디버깅용 로그
                    return s.startsWith("b");
                })
                .map(s -> {
                    System.out.println("map: " + s);  // 디버깅용 로그
                    return s.toUpperCase();
                })
                .forEach(System.out::println);
    }

    public static void break_과_continue_는_불가능() {
        // break, continue 같은 명령은 스트림 API에서는 직접 사용 불가능
        // 복잡한 흐름 제어가 필요하면 무조건 for문 사용
        List<String> list = List.of("a", "b", "c", "d");

        for (String s : list) {
            if (s.equals("c")) break;  // break 가능
            System.out.println(s);
        }

        // 스트림에서는 불가능
        list.stream()
                .takeWhile(s -> !s.equals("c"))  // Java 9 이상
                .forEach(System.out::println);
    }

    public static void 성능이_항상_더_좋은건_아님(){
        // 데이터 양이 많을 때, 단순 for문이 스트림보다 빠른 경우도 많음
        // 특히 boxed() 때문에 오히려 스트림이 느려질 수도 있음
        List<Integer> nums = IntStream.range(0, 1_000_000)
                .boxed()
                .collect(Collectors.toList());

        long start1 = System.nanoTime();
        int sum1 = 0;
        for (int i : nums) sum1 += i;
        System.out.println("for문 sum: " + sum1 + " (" + (System.nanoTime() - start1)/1_000_000 + "ms)");

        long start2 = System.nanoTime();
        int sum2 = nums.stream().mapToInt(i -> i).sum();
        System.out.println("스트림 sum: " + sum2 + " (" + (System.nanoTime() - start2)/1_000_000 + "ms)");
    }

    public static void 무리한_체이닝은_가독성이_떨어짐(){
        List<Person> people = List.of(
                new Person("kim", 25),
                new Person("lee", 17),
                new Person("park", 30),
                new Person("choi", 19),
                new Person("jung", 22),
                new Person("kang", 24)
        );
        List<String> result = people.stream()
                .filter(p -> p.getAge() > 18)
                .map(p -> p.getName().toUpperCase())
                .sorted((a, b) -> a.compareTo(b))
                .limit(5)
                .collect(Collectors.toList());
    }

    static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() { return name; }
        public int getAge() { return age; }
    }

    public static void 스트림은_순수_함수_중심의_사고에_적합(){
        // 스트림 내부에서는 외부 상태를 변경하지 않아야 한다.
        // 이런 식으로 상태를 변경하면 함수형 스타일을 깨고, 버그의 원인이 될 수 있음
        // 스트림은 가능한 한 상태를 변경하지 않도록 설계됨
        List<String> globalList = new ArrayList<>();
        List<String> names = List.of("kim", "lee", "park");

        List<String> result = names.stream()
                .map(s -> {
                    // 외부 상태 변경하면 함수형 스타일 아님 (반칙)
                    globalList.add(s);  // side effect 발생
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
    }
}
