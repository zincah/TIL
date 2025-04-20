package org.example.effective.item3_singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * Enum방식 (가장 안전한 싱글턴)
 * 직렬화/역직렬화 문제 자동 해결
 * 리플렉션으로 깨는 것도 불가능
 * 가장 간단하고 안전
 *
 * lazy loading 불가
 * 상속 불가
 */
@Slf4j
public enum EnumSingleton {
        INSTANCE;

        public void printLogging(){
        log.info("{} 동작 중!", this.getClass().getName());
    }
}
