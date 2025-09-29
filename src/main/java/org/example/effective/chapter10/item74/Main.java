package org.example.effective.chapter10.item74;

/**
 * Item 74 : 메서드가 던지는 모든 예외를 문서화하라
 *
 * 메서드나 생성자가 던질 수 있는 모든 예외(checked + unchecked)를 정확하고 명확하게 문서화해야 한다.
 * 문서화 방법은 JavaDoc의 @throws 태그를 사용하는 것이 일반적이다.
 * 선언된 예외뿐 아니라 발생 가능한 모든 예외를 문서화해야 한다.
 * (정확히 throw 선언 안 하더라도 런타임 예외도 포함!)
 * API 사용자(메서드 호출자)는 어떤 예외가 발생할 수 있는지 이해할 수 있어야 한다.
 * 예외가 언제, 왜, 어떤 조건에서 발생하는지를 설명하라.
 */
public class Main {

    public static void main(String[] args) {

        int r1 = Caculator.badDivide(10, 0);
        int r2 = Caculator.goodDivide(10, 0);
    }
}
