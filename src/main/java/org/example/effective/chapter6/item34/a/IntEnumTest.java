package org.example.effective.chapter6.item34.a;

import static org.example.effective.chapter6.item34.a.IntEnum.*;

/**
 * 정수 열거 패턴에는 단점이 많다.
 * - 오렌지를 건내야할 메서드에 사과를 보내도 컴파일러는 경고 조차 하지않는다.
 * - 컴파일 후 출력하거나 디버깅 하는경우 단순한 숫자로 보인다
 * - 그룹에 속한 상수가 몇 개 인지 모른다 (APPLE과 BANANA가 각각 몇개인지 모름)
 *
 * -> 이 모든 단점을 해결하는것이 열거타입(enum)이다.
 */
public class IntEnumTest {
    int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;
}
