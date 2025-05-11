package org.example.effective.chapter4.item20.skeleton;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ElectricCar extends AbstractVehicle implements ElectricPowered{

    @Override
    public void move() {
      log.debug("조용하게 도로를 달립니다.");
    }

    @Override
    public int batteryStatus() {
        return 85;
    }
}
