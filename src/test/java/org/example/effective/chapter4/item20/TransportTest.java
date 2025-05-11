package org.example.effective.chapter4.item20;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter4.item20.skeleton.ElectricCar;
import org.example.effective.chapter4.item20.skeleton.ElectricPowered;
import org.example.effective.chapter4.item20.skeleton.GasolineCar;
import org.example.effective.chapter4.item20.skeleton.Vehicle;
import org.junit.jupiter.api.Test;

@Slf4j
public class TransportTest {

    @Test
    public void test(){

        Vehicle tesla = new ElectricCar();
        Vehicle benz = new GasolineCar();

        tesla.start();
        tesla.move();
        log.debug(((ElectricPowered)tesla).charge());
        log.debug("batteryStatus : {}", ((ElectricPowered) tesla).batteryStatus());
        tesla.stop();

        benz.start();
        benz.move();
        benz.stop();
    }
}
