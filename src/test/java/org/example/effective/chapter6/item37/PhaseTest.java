package org.example.effective.chapter6.item37;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter6.item37.bad.BadPhase;
import org.example.effective.chapter6.item37.good.GoodPhase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
public class PhaseTest {

    // ordinal index 사용
    @Test
    public void testTransitionFromBadExample() {
        // SOLID -> LIQUID = MELT
        BadPhase.Transition t1 = BadPhase.Transition.from(BadPhase.SOLID, BadPhase.LIQUID);
        assertEquals(BadPhase.Transition.MELT, t1);

        // LIQUID -> GAS = BOIL
        BadPhase.Transition t2 = BadPhase.Transition.from(BadPhase.LIQUID, BadPhase.GAS);
        assertEquals(BadPhase.Transition.BOIL, t2);

        // GAS -> SOLID = DEPOSIT
        BadPhase.Transition t3 = BadPhase.Transition.from(BadPhase.GAS, BadPhase.SOLID);
        assertEquals(BadPhase.Transition.DEPOSIT, t3);
    }

    // enum map 사용
    @Test
    public void testTransitionFromEnumMap() {
        // SOLID -> LIQUID = MELT
        GoodPhase.Transition t1 = GoodPhase.Transition.from(GoodPhase.SOLID, GoodPhase.LIQUID);
        assertEquals(GoodPhase.Transition.MELT, t1);

        // LIQUID -> GAS = BOIL
        GoodPhase.Transition t2 = GoodPhase.Transition.from(GoodPhase.LIQUID, GoodPhase.GAS);
        assertEquals(GoodPhase.Transition.BOIL, t2);

        // GAS -> SOLID = DEPOSIT
        GoodPhase.Transition t3 = GoodPhase.Transition.from(GoodPhase.GAS, GoodPhase.SOLID);
        assertEquals(GoodPhase.Transition.DEPOSIT, t3);

        // 잘못된 전이 (존재하지 않는 전이)
        assertNull(GoodPhase.Transition.from(GoodPhase.SOLID, GoodPhase.SOLID));
    }
}
