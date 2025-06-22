package org.example.effective.chapter6.item39;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class RunTests {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for(Method m : testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(Test.class)){
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
