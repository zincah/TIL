package org.example.effective.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * DCL : Double-Checked Locking
 * lazy + 멀티스레드 안전 + 성능 좋음
 * 대부분 상황에서 성능/안전성 균현 good
 *
 * 코드 복잡도 올라감
 * volatile 키워드 필요
 */
@Slf4j
public class DCLSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    // volatile -> 인스턴스 생성 시 중간 단계 캐싱 방지 (JVM이 객체 생성 중간 단계를 캐시하지 않도록 방지)
    private static volatile DCLSingleton instance;

    private DCLSingleton(){
        log.info("{} 생성자 호출", this.getClass().getName());
    }

    public static DCLSingleton getInstance(){
        if(instance == null){
            synchronized (DCLSingleton.class){
                if(instance == null){
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    // 역직렬화 시 싱글톤 보장
    private Object readResolve(){
        return getInstance();
    }

    public void printLogging(){
        log.info("{} 동작 중!", this.getClass().getName());
    }
}
