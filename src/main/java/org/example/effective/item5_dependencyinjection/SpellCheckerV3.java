package org.example.effective.item5_dependencyinjection;

import java.util.function.Supplier;

/**
 * item5 : 의존 객체 주입
 * - supplier 활용 방식
 */
public class SpellCheckerV3 {
    private final Dictionary dictionary;

    public SpellCheckerV3(Supplier<Dictionary> dictionaryFactory) {
        // 지연 생성 가능 : supplierd의 get 메소드로 get이 호출될때 Dictionary(객채)가 생성
        this.dictionary = dictionaryFactory.get();
    }

    public boolean isValid(String word){
        return dictionary.contains(word);
    }
}
