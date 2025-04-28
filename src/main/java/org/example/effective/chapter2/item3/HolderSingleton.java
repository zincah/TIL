package org.example.effective.chapter2.item3;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 정적 내부 클래스 방식
 * 클래스가 처음 로딩될 때까지 인스턴스 생성 안 함 -> lazy
 * JVM 클래스 로딩 메커니즘 덕분에 스레드 안전 보장
 * 성능 좋음
 */
@Slf4j
public class HolderSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private HolderSingleton(){
        log.info("{} 생성자 호출", this.getClass().getName());
    }

    private static class Holder{
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance(){
        return Holder.INSTANCE;
    }

    // 역직렬화 시 싱글톤 보장
    private Object readResolve(){
        return getInstance();
    }

    public void printLogging(){
        log.info("{} 동작 중!", this.getClass().getName());
    }
}
