package org.example.effective.chapter4.item21.good;

/**
 * 안전하게 디폴트 메서드를 확장하는 3가지 패턴
 * 1. 새 인터페이스로 분리해서 확장하기
 */
public interface Printer {
    void print(String message);
}

interface TimestampedPrinter extends Printer{
    default void printWithTimestamp(String message){
        message = System.currentTimeMillis() + message;
        print(message);
    }
}
