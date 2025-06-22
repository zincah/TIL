package org.example.effective.chapter6.item37;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class PlantTest {

    // 테스트 대상: 다양한 생애주기를 가진 식물들
    Plant[] garden = {
            new Plant("튤립", Plant.LifeCycle.PERENNIAL),
            new Plant("당근", Plant.LifeCycle.BIENNIAL),
            new Plant("옥수수", Plant.LifeCycle.ANNUAL),
            new Plant("국화", Plant.LifeCycle.PERENNIAL),
            new Plant("무", Plant.LifeCycle.BIENNIAL)
    };

    /**
     * Plant 예제
     * - 집합들을 배열 하나에 넣고 생애주기의 ordinal 값을 그 배열의 인덱스로 사용
     *
     * ordinal()은 enum 상수의 순서에 의존하기 때문에, 중간에 새 값을 추가하거나 순서 바꾸면 데이터가 잘못 분류됨. (컴파일러가 잡아줄 수 없는 버그라 위험함)
     * Enum객체에 새로운 상수가 추가될 경우 오류 발생
     */
    @Test
    public void useOrdinalIndexing(){
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[])new Set[Plant.LifeCycle.values().length];
        for(int i=0; i<plantsByLifeCycle.length; i++){
            plantsByLifeCycle[i] = new HashSet<>();
        }

        for(Plant p : garden){
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        for(int i=0; i<plantsByLifeCycle.length; i++){
            log.debug("{} : {}", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }

        // 이렇게 코드가 ordinal 에 완전히 의존하고 있는 것이 좋지 않음
        // 아래처럼 상수에 기존에 알고있었던 인덱스를 사용하다가 enum 상수가 추가되거나 삭제되면 문제
        // 배열의 크기를 정적 구조 (= new Set[4]) 이렇게 사용해도 문제
        // 데이터 직렬화 또는 저장시에 ordinal 값으로 저장하면 값의 의미가 완전히 달라질 수 있기에 문제
        // 숫자만 보고서 바로 코드상 의미를 파악할 수 없다는 문제 등 여러 문제가 존재
        int perennialIndex = 1;

        // 기존의 저장되어있던 인덱스 값으로 찾으면 찾지못하는 것을 의도하여 테스트 코드 작성
        assert !plantsByLifeCycle[1].contains(new Plant("튤립", Plant.LifeCycle.PERENNIAL));
    }

    @Test
    public void useEnumMap(){
        EnumMap<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for(Plant.LifeCycle lc : Plant.LifeCycle.values()){
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for(Plant p : garden){
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        for(Plant.LifeCycle lc : plantsByLifeCycle.keySet()){
            log.debug("{} : {}", lc, plantsByLifeCycle.get(lc));
        }

        // 여기는 enum 순서가 바뀌든 말든 안전!
        assert plantsByLifeCycle.get(Plant.LifeCycle.PERENNIAL)
                .contains(new Plant("튤립", Plant.LifeCycle.PERENNIAL));
    }
}
