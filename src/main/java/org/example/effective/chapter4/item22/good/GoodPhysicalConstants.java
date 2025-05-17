package org.example.effective.chapter4.item22.good;

/**
 * 상수를 사용하기 위해서 권장되는 방식 : final class + static import
 */
public class GoodPhysicalConstants {
    private GoodPhysicalConstants() {} // 인스턴스 생성 방지
    public static final double AVOGADROS_NUMBER = 6.022_140_76e23;
    public static final double BOLTZMANN_CONSTANT = 1.380_649e-23;
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}
