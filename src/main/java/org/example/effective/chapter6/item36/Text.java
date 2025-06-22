package org.example.effective.chapter6.item36;

import java.util.EnumSet;
import java.util.Set;

public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    public void applyStyle(Set<Style> styles) {}

    public static void main(String[] args) {
        Text t = new Text();
        //여러가지 상태를 한번에 받을 수 있음
        t.applyStyle(EnumSet.of(Style.BOLD, Style.ITALIC, Style.STRIKETHROUGH));
    }

    /**
     * EnumSet은 내부적으로 비트타입으로 구현
     * EnumSet.of(BOLD, ITALIC) -> 내부적으로 비트 마스크를 생성
     * contains(BOLD) -> 비트 연산을 사용하여 검사함
     * 즉, EnumSet은 비트 연산을 감싼 고수준 API
     */

}
