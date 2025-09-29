package org.example.effective.chapter10.item75;

/**
 *  Item 75 : 실패를 일으킨 정보를 예외 메시지에 담아라
 *
 * 예외가 발생했을 때, 그 원인을 추적하거나 디버깅할 수 있도록 충분한 정보를 예외 메시지에 포함하라.
 * 흔한 실수는 throw new Exception("처리 실패")처럼 너무 추상적인 메시지를 다는 것 → 디버깅할 수 없음
 * 실패 원인 대상(예: "실패한 값", "실패한 파일명", "문제의 키" 등)을 구체적으로 예외 메시지에 넣도록 하자.
 * 예외 메시지는 개발자에게 전달되는 중요한 "문맥 정보"이고, 로그나 모니터링 시스템에서도 유용하게 쓰인다.
 */
public class Main {

    public static void main(String[] args) {
        //BadExample.divide(10, 0);
        GoodExample.divide(10, 0);
    }
}
