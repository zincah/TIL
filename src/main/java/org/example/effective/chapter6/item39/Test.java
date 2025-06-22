package org.example.effective.chapter6.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 테스트 메서드임을 선언하는 애너테이션
 * 매개변수 없는 정적 메서드 전용
 * - 아무 매개변수 없이 단순히 대상에 마킹한다는 뜻에서 마커애너테이션
 *
 * 애너테이션 선언에 다는 애너테이션 = 메타애너테이션
 */
@Retention(RetentionPolicy.RUNTIME) // @Test가 런타임에도 유지되어야한다는표시
@Target(ElementType.METHOD) // @Test가 메서드 선언에만 사용됨
public @interface Test {
}
