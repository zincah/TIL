package org.example.effective.chapter2.item5;

import java.util.Objects;

/**
 * item5 : 의존 객체 주입
 * - 의존 객체 주입 사용
 */
public class SpellCheckerV2 {
    private final Dictionary dictionary;

    /** 생성자를 통해 Dictionary 구현체를 외부에서 주입받을 수 있기때문에 유연성, 테스트용이성, 재사용성이 좋아짐 **/
    public SpellCheckerV2(Dictionary dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word){
        return dictionary.contains(word);
    }
}
