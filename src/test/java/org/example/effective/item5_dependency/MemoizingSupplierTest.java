package org.example.effective.item5_dependency;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.item5_dependencyinjection.Dictionary;
import org.example.effective.item5_dependencyinjection.SpellCheckerV3;
import org.example.effective.item5_dependencyinjection.dictionary.DefaultDictionary;
import org.example.effective.item5_dependencyinjection.supplier.MemoizingSupplier;
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
