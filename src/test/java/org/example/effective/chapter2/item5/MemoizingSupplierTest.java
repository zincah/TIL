package org.example.effective.chapter2.item5;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter2.item5.dictionary.DefaultDictionary;
import org.example.effective.chapter2.item5.supplier.MemoizingSupplier;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

@Slf4j
public class MemoizingSupplierTest {

    @Test
    public void testMomoizedSupplier(){
        Supplier<Dictionary> supplier = () -> new DefaultDictionary();

        Supplier<Dictionary> memoized = new MemoizingSupplier<>(supplier);

        SpellCheckerV3 checker = new SpellCheckerV3(memoized);

        log.debug("dictionary hello -> " + checker.isValid("hello"));
        log.debug("dictionary bye -> " + checker.isValid("bye"));
    }
}
