package my.wonseok.chapter02.item18;

import my.wonseok.chapter02.item18.composition.Dog;
import my.wonseok.chapter02.item18.composition.InstrumentedSet;
import my.wonseok.chapter02.item18.extend.InstrumentedHashSet;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 상속보다는 컴포지션을 사용하라
 *  - 다른 패키지를 상속하는건 위험
 *  - 상속은 캡슐화를 깨트림
 *  - 상속은 반드시 클래스B가 클래스A와 is-a 관계여야함
 */
public class Main {

    public static void main(String[] args) {
        extendTestA();


    }

    /**
     * 상속화를 깨트림
     * 예상 3, 실제 6
     * HashSet addAll 메소드에서 add 메소드를 한번 더 호출하기 때문에 count를 한번 더 증가시킴
     * 상위클래스의 함수가 수정되는경우 하위클래스에 영향이감
     */
    public static void extendTestA(){
        InstrumentedHashSet<String> instrumentedHashSet = new InstrumentedHashSet<>();
        instrumentedHashSet.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println(instrumentedHashSet.getAddCount());
    }

    /**
     * Set 인스턴스를 특정 조건하에 임시로 계측
     * 다른 Set을 감싸고 있는 InstrumentedSet을 wrapper 클래스라고함 (데코레이터 패턴)
     * 구아바 라이브러리에 모든 컬렉션 인터페이스용 전달 메서드를 구현해 놓음
     * @param dogs
     */
    public static void compositionTestA(Set<Dog> dogs) {
        InstrumentedSet<Dog> IDogs = new InstrumentedSet<>(dogs);
    }
}
