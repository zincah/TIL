package org.example.effective.chapter3.item15;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter3.item15.nested.InputProcessor;
import org.junit.jupiter.api.Test;

@Slf4j
public class ValidatorTest {

    @Test
    public void validation(){
        InputProcessor simpleProcessor
                = new InputProcessor(InputProcessor.Mode.SIMPLE);
        log.error("" + simpleProcessor.process(""));
        log.error("" + simpleProcessor.process("abc"));

        InputProcessor regexProcessor
                = new InputProcessor(InputProcessor.Mode.REGEX);
        log.error("" + regexProcessor.process("abc124"));
        log.error("" + regexProcessor.process("abc!!!"));




    }
}
