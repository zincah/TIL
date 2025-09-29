package org.example.effective.chapter10.item73;

/**
 * Item 73 요약: 추상화 수준에 맞는 예외를 사용하라
 * 라이브러리/모듈을 설계할 때, 내부 구현 세부사항이 아닌 외부 클라이언트 관점에서 의미 있는 예외를 던져야 한다.
 * 내부에서 발생한 저수준 예외를 그대로 전파하면 API 사용자에게 혼란을 줄 수 있다.
 * 상위 계층에서는 저수준 예외를 잡아 자신의 추상화 수준에 맞는 예외로 바꿔 던져야 한다. (Exception translation)
 *
 *
 * API 사용자에게 더 명확하고 처리 가능한 예외를 제공할 수 있다.
 * 구현을 변경하더라도 API 예외 구조는 유지할 수 있어 캡슐화를 지킬 수 있다.
 */
public class Main {

    public static void main(String[] args) {
        FileProcessorGood processor = new FileProcessorGood();
        try {
            String config = processor.readFirstLine("config.txt");
            System.out.println("설정: " + config);
        } catch (CruzlinkException e) {
            System.err.println("사용자 친화적 오류 처리: " + e.getMessage());
            // 필요 시 cause(원인) 로그 출력도 가능
        }
    }
}
