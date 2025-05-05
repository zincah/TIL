package org.example.effective.chapter3.item15.nested;

/**
 * 중첩 인터페이스 + 중첩 구현 클래스
 * 전략이 고정되어 있고 외부에서 전략을 직접 주입할 필요가 없을 때 이상적
 *
 * 장점
 * 1. 캡슐화 강화
 * 2. 응집도 향상
 * 3. 불필요한 타입 노출 방지
 * 4. 전략 교체는 가능하지만 제어권은 클래스에 있음
 * 5. 테스트 쉬움
 * -> "단일책임원칙(SRP) + 정보은닉원칙 + 안정적인 확장" 원칙을 반영한 구조
 */
public class InputProcessor {
    public enum Mode {
        SIMPLE, REGEX
    }

    private final Validator validator;

    public InputProcessor(Mode mode) {
        switch (mode) {
            case REGEX:
                this.validator = new RegexValidator();
                break;
            case SIMPLE:
            default:
                this.validator = new SimpleValidator();
        }
    }

    public boolean process(String input) {
        return validator.isValid(input);
    }

    // ❗외부에 노출되지 않도록 숨긴 인터페이스
    private static interface Validator {
        boolean isValid(String input);
    }

    // ❗단일 클래스 안에서만 쓰는 전략 구현체들
    private static class SimpleValidator implements Validator {
        public boolean isValid(String input) {
            return input != null && !input.isEmpty();
        }
    }

    private static class RegexValidator implements Validator {
        public boolean isValid(String input) {
            return input != null && input.matches("[a-zA-Z0-9]+");
        }
    }
}
