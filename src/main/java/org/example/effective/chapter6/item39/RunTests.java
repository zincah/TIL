package org.example.effective.chapter6.item39;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 아이템 39: 명명 패턴보다 애너테이션을 사용하라
 * - 테스트 메서드처럼 특정 목적을 갖는 코드를 구분할 때, 특정 메소드를 만들어서(testSomething...) 명명 패턴에 의존하지 말고 애너테이션을 사용하는 것을 권유
 *
 * 애너테이션 사용 강점
 * 1. 명확성
 * 2. 리플렉션으로 탐지 쉬움 (method.isAnnotationPresent(..class))
 * 3. 유연한 확장 가능
 */
@Slf4j
public class RunTests {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for(Method m : testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(Test.class)){ // 리플렉션으로 탐지 쉬움
                tests++;
                try{
//                    Sample s = new Sample();
//                    m.invoke(s); // 인스턴스 메서드는 이렇게 사용해야함
                    m.invoke(null); // 정적 메서드일 경우에만 이처럼 사용
                    passed++;
                }catch (InvocationTargetException ite){
                    Throwable e = ite.getCause();
                    log.error("{} 실패 : {}", m, e);
                }catch (Exception e){
                    log.error("애너테이션 잘못 사용 : " + e);
                }
            }
        }

        for(Method m : testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(ExceptionTest.class)){
                tests++;
                try{
                    m.invoke(null); // 정적 메서드일 경우에만 이처럼 사용
                    log.error("테스트 {} 실패 : 예외가 발생하지 않음", m);
                }catch (InvocationTargetException ite){
                    Throwable e = ite.getCause();
                    Class<? extends Throwable> eType =
                            m.getAnnotation(ExceptionTest.class).value();
                    if(eType.isInstance(e)){
                        passed++;
                    }else{
                        log.error("테스트 {} 실패: 기대한 예외 {}, 발생한 예외 {}"
                                , m, eType.getName(), e.getMessage());
                    }
                }catch (Exception e){
                    log.error("애너테이션 잘못 사용 : " + e);
                }
            }
        }

        log.debug("성공: {}, 실패: {}", passed, tests-passed);
    }
}
