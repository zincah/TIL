package org.example.effective.chapter4.item22.bad;

/**
 * 상수 인터페이스는 상속의 잘못된 사용이다. -> 상수 값에 접근하는 목적만으로 타입 계층에 포함되는 것이기 때문
 * 1. 구현 클래스가 불필요하게 인터페이스의 하위 타입이 되어버림
 *      -> BadPhysicalConstants를 구현한 클래스는 인터페이스의 하위 타입이 됨
 *      -> BadPhysicalConstants 타입의 객체라는 것을 선언한다는 뜻
 *      -> 이는 상속과 타입 시스템을 오용한 것, 타입 시스템은 이 객체가 어떤 행위를 하는가를 표현해야하는데 상수는 행위가 아니라 정적인 데이터이기 때문에 잘못 사용하는 것
 * 2. 구현 클래스의 API가 오염되며 캡슐화가 파괴됨 (불필요한 상수 노출)
 *      -> 구현하는 클래스의 문서를 보면 상수들이 모두 노출되고 상수 이름을 변경하면 해당 인터페이스를 implements한 모든 클래스가 영향을 받음
 */
public interface BadPhysicalConstants {
    static final double AVOGADROS_NUMBER = 6.022_140_76e23;
    static final double BOLTZMANN_CONSTANT = 1.380_649e-23;
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}
