package org.example.effective.chapter6.item37.good;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GoodPhase {

    SOLID,
    LIQUID,
    GAS,
    PLASMA; // PLASMA 추가

    public enum Transition {
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA), // PLASMA 추가
        DEIONIZE(PLASMA, GAS); // PLASMA 추가

        private final GoodPhase from;
        private final GoodPhase to;

        Transition(GoodPhase from, GoodPhase to) {
            this.from = from;
            this.to = to;
        }

        // EnumMap을 중첩 사용한 타입 안전한 전이 맵
        private static final Map<GoodPhase, Map<GoodPhase, Transition>> TRANSITION_MAP = new EnumMap<>(GoodPhase.class);

        static {
            for (GoodPhase p : GoodPhase.values()) {
                TRANSITION_MAP.put(p, new EnumMap<>(GoodPhase.class));
            }
            for (Transition t : values()) {
                TRANSITION_MAP.get(t.from).put(t.to, t);
            }
        }

        // + stream 전이 메소드
//        private static final Map<GoodPhase, Map<GoodPhase, Transition>>
//            m = Stream.of(values()).collect(Collectors.groupingBy(t -> t.from,
//                () -> new EnumMap<>(GoodPhase.class),
//                Collectors.toMap(t -> t.to, t -> t,
//                        (x, y) -> y, () -> new EnumMap<>(GoodPhase.class))));

        public static Transition from(GoodPhase from, GoodPhase to) {
            return TRANSITION_MAP.get(from).get(to);
        }

//        public static Transition from(GoodPhase from, GoodPhase to) {
//            return m.get(from).get(to);
//        }

    }

}
