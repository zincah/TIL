package org.example.effective.chapter3.item11.test;

import org.example.effective.chapter3.item11.hashcode.GoodCode;
import org.example.effective.chapter3.item11.hashcode.NoCode;
import org.example.effective.chapter3.item11.hashcode.WorstCode;

import java.util.HashMap;
import java.util.Map;
/**
 * study
 * hashcode란?
 * - 객체의 메모리 주소를 기반으로한 정수값 생성
 * - 객체의 동일성 비교를 위한 첫 단계로 활용
 * - 서로 다른 해시값에 대해서는 다른 해시값을 반환하는 것이 좋음
 *
 * 규약
 * - 일관성: 같은 객체에 대해 같은 값 반환
 * - 동등성: equals()가 true면 같은 값 반환
 */
public class HashCodeTest {
    public static void main(String[] args) {
        Map<WorstCode, String> worstMap = new HashMap<>();
        WorstCode worstCodeA = new WorstCode("A", "A");
        WorstCode worstCodeB = new WorstCode("B", "B");

        System.out.println(worstCodeA.equals(worstCodeB));
        System.out.println(worstCodeA.hashCode());
        System.out.println(worstCodeB.hashCode());

        worstMap.put(worstCodeA, "A");
        worstMap.put(worstCodeB, "B");

        String s = worstMap.get(new WorstCode("B", "B"));
        System.out.println(s);

        System.out.println("-------------------------------------");

        Map<GoodCode, String> goodMap = new HashMap<>();
        GoodCode goodCodeA = new GoodCode("A", "A");
        GoodCode goodCodeB = new GoodCode("A", "A");

        System.out.println(goodCodeA.equals(goodCodeB));
        System.out.println(goodCodeA.hashCode());
        System.out.println(goodCodeB.hashCode());
        // gid와 interfaceid 기반으로 hashcode 생성하였기 때문에
        // 동일한 hashcode반환

        goodMap.put(goodCodeA, "A");
        goodMap.put(goodCodeB, "B");

        s = goodMap.get(new GoodCode("B", "B"));
        System.out.println(s);



        System.out.println("-------------------------------------");
        Map<NoCode, String> noMap = new HashMap<>();
        NoCode noCodeA = new NoCode("A", "A");
        NoCode noCodeB = new NoCode("A", "A");

        System.out.println(noCodeA.equals(noCodeB));
        System.out.println(noCodeA.hashCode());
        System.out.println(noCodeB.hashCode());
        //동일하지 않은 hashcode 반환

        noMap.put(noCodeA, "A");
        noMap.put(noCodeB, "B");

        //hashcode가 정의되지않아 null 반환
        s = noMap.get(new NoCode("B", "B"));
        System.out.println(s);
    }
}
