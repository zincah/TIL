package org.example.effective.chapter2.item5;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter2.item5.dictionary.DefaultDictionary;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

@Slf4j
public class SpellCheckerTest {

    @Test
    public void spellCheckerV2Test(){
        Dictionary dictionary = new DefaultDictionary();
        SpellCheckerV2 checker = new SpellCheckerV2(dictionary);

        log.debug("dictionary hello -> " + checker.isValid("hello"));
        log.debug("dictionary bye -> " + checker.isValid("bye"));
    }

    @Test
    public void spellCheckerV3Test(){
        Supplier<Dictionary> dictionary = () -> new DefaultDictionary();
        SpellCheckerV3 checker = new SpellCheckerV3(dictionary);

        // supplier는 호출 시 마다 동적 객체 재생성이 됨
        log.debug("dictionary hello -> " + checker.isValid("hello"));
        log.debug("dictionary bye -> " + checker.isValid("bye"));
    }

    /**
     * supplier 호출 시 마다 동적 객체 재생성을 방지하기 위한 방법
     * 1. 캐싱 Supplier 패턴
     * Supplier를 래핑해서 재사용 가능한 유틸을 만들고 싶다면 memoization 유틸을 만들어서 활용할 수 있음
     */
    @Test
    public void cachedSupplierTest(){
        Supplier<Dictionary> cachedSupplier = new Supplier<Dictionary>() {
            private Dictionary instance;
            @Override
            public Dictionary get() {
                if(instance == null){
                    instance = new DefaultDictionary();
                    log.debug("Dictionary 인스턴스 최초 생성");
                }
                return instance;
            }
        };

        SpellCheckerV3 checker = new SpellCheckerV3(cachedSupplier);
        log.debug("dictionary hello -> " + checker.isValid("hello"));
        log.debug("dictionary bye -> " + checker.isValid("bye"));
    }

    /**
     * supplier 호출 시 마다 동적 객체 재생성을 방지하기 위한 방법
     * 2. 고정된 인스턴스 반환
     */
    public void fixedSupplierTest(){
        Dictionary dictionary = new DefaultDictionary();
        Supplier<Dictionary> fixedSupplier = () -> dictionary;

        SpellCheckerV3 checker = new SpellCheckerV3(fixedSupplier);
        log.debug("dictionary hello -> " + checker.isValid("hello"));
        log.debug("dictionary bye -> " + checker.isValid("bye"));
    }
}
