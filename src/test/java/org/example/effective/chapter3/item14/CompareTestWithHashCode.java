package org.example.effective.chapter3.item14;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class CompareTestWithHashCode {

    List<Object> list = new ArrayList<>();

    /**
     * 해시코드는 정렬 기준으로 삼기에 부적절하며, 꼭 써야한다면
     * 아래의 goodComparator 예시 처럼 사용해야함
     *
     * 추이성이란?
     * 만약 a > b이고 b > c이면, 반드시 a > c여야 한다.
     */
    @Test
    public void compareTest(){
        // 해시 충돌이 없는 값으로 보장할 수는 없지만, 예시를 위해 일부 객체를 추가
        // 특정 문자열 조합으로 hashCode가 같을 수 있음
        list.add("AaAaAa");
        list.add("BBAaBB");
        list.add("CCCCCC");
        list.add("DDDDDD");

        // 잘못된 Comparator : 정수 오버플로우 발생 가능성 있음, 추이성을 보장하지 않음
        Comparator<Object> badComparator = (o1, o2) -> o1.hashCode() - o2.hashCode();

        // 정렬 시도
        Collections.sort(list, badComparator);

        for (Object o : list) {
            log.debug(o + " → " + o.hashCode());
        }

        // 안전한 Comparator 사용
        // Integer.compare() 또는 Comparator.comparingInt() 를 사용하면 내부적으로 뺄셈을 사용하지 않기에 오버플로우 발생 x, 추이성 보장가능
        Comparator<Object> goodComparator = Comparator.comparingInt(Object::hashCode);

        // 정렬
        Collections.sort(list, goodComparator);

        for (Object o : list) {
            log.debug(o + " → " + o.hashCode());
        }
    }




}
