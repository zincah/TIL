package org.example.effective.chapter4.item23;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter4.item23.hierarchy.record.Circle;
import org.example.effective.chapter4.item23.hierarchy.record.Figure;
import org.junit.jupiter.api.Test;

@Slf4j
public class RecordTest {
    @Test
    public void recordTest(){
        double radius = 2.0;
        Figure circle = new Circle(radius);
        log.debug("원의 넓이 : {}", circle.area());
        log.debug("원의 반지름 : {}", ((Circle)circle).radius()); // record형 클래스에서는 getRadius() 와 동일
    }
}
