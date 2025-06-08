package org.example.effective.chapter5.item28;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class ChooserTest {
    @Test
    public void chooser1Test(){
        Chooser1 chooser = new Chooser1(List.of("a", "b", "c"));
        try {
            String choice = (String) chooser.choose(); // 동작
            int wrongChoice = (int) chooser.choose();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException 발생 : " + e);
        }
    }

    @Test
    public void chooser2Test(){
        List<String> names = List.of("운동", "공부", "게임");
        Chooser2<String> chooser = new Chooser2<>(names);

        String selected = chooser.choose();
        System.out.println("선택된 항목: " + selected);
    }
}
