package org.example.effective.chapter6.item37;

/**
 * 아이템37 : ordinal 인덱싱 대신 EnumMap을 사용하라 (ordinal 인덱싱을 사용하는 예제와 EnumMap을 사용하는 예제를 비교)
 *
 * Plant 예제
 * 정원에 심은 식물들을 배열 하나로 관리하고, 이들을 생애주기(한해살이, 여러해살이, 두해살이)별로 묶기
 * 생애주기별로 총 3개의 집합을 만들고 정원안에 있는 각 식물들을 해당 집합에 넣는다.
 *
 * ordinal 인덱싱 사용 vs EnumMap 사용을 비교하기 위해 enum 새로운 값을 추가한다.
 */
public class Plant {
    enum LifeCycle {
        ANNUAL,
        SHORT_LIVED,
        PERENNIAL,
        BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString(){
        return name;
    }
}
