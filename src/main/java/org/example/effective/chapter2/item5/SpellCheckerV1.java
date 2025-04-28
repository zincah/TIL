package org.example.effective.chapter2.item5;

import org.example.effective.chapter2.item5.dictionary.DefaultDictionary;

/**
 * item5 : 의존 객체 주입
 * - 자원을 직접 명시하는 좋지 않은 예시
 */
public class SpellCheckerV1 {

    /** SpellCheckerV1 은 오직 하나의 Dictionary 구현체에만 종속되며, 테스트가 어렵고, 재사용도 어렵고, 유연하지 않음 **/
    private static final Dictionary dictionary = new DefaultDictionary();

    public static boolean isValid(String word){
        return dictionary.contains(word);
    }

}
