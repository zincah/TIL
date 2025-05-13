package org.example.effective.chapter4.item21;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter4.item21.good.MyReadOnlyList2;
import org.example.effective.chapter4.item21.issue.MyReadOnlyList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class DefaultMethodTest {

    @Test
    public void myReadOnlyList(){
        List<String> list = new MyReadOnlyList<>(List.of("apple", "banana"));

        // default 메서드 removeIf() 호출
        list.removeIf(s -> s.startsWith("a"));
    }

    @Test
    public void myReadOnlyList2(){
        List<String> list = new MyReadOnlyList2<>(List.of("apple", "banana"));

        // default 메서드 removeIf() 호출
        UnsupportedOperationException thrown =
                assertThrows(UnsupportedOperationException.class,
                        () -> list.removeIf(s -> s.startsWith("a")));

        assertEquals("Read-only", thrown.getMessage());
        log.error("에러 발생 : " + thrown.getMessage());
    }
}
