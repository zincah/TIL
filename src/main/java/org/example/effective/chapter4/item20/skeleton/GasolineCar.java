package org.example.effective.chapter4.item20.skeleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GasolineCar extends AbstractVehicle{
    @Override
    public void move() {
        log.debug("우르르쾅쾅 도로를 달립니다.");
    }
}
