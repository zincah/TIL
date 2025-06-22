package org.example.effective.chapter6.item37.bad;

/**
 * ordinal 단점
 * 1. 순서 의존 : ordinal()은 enum 선언 순서가 바뀌면 값이 바뀜
 * 2. 배열 하드코딩 : 현재 2차원 배열의 phase순서를 가정하여 하드코딩함
 * 3. 코드 유지보수성 낮음 : enum 수정 시 Transition을 수정하지 않으면 오류 발생
 * 4. 컴파일 됨 -> 논리 오류 발생
 */
public enum BadPhase {
    SOLID,
//    PLASMA,  // 추가
    LIQUID,
    GAS;

    public enum Transition{
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // 행은 from의 ordinal을, 열은 to의 ordinal을 인덱스로 쓴다.
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        // 한 상태에서 다른 상태로의 전이를 반환하는 메서드
        public static Transition from(BadPhase from, BadPhase to){
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}

