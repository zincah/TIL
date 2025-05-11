package org.example.effective.chapter4.item20.skeleton;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * 추상 골격 클래스 (공통 기능 제공)
 *
 * 1. 중복제거 : 인터페이스 구현 시 반복되는 코드 줄이기 (모든 서브클래스에서 코드 재사용 가능)
 * 2. 공통 동작 개별 동작 분리 : 추상골격클래스에 공통 메서드 구현
 * -> 핵심 메서드만 추상 메서드로 남겨서 하위 클래스가 구현하게 함 (템플릿 메서드 패턴)
 * 3. 인터페이스의 유연성과 추상 클래스의 구현 재사용
 * -> 인터페이스만 사용할 경우 모든 구현을 직접 해야 해서 번거롭고 중복
 * -> 추상 클래스만 사용하면 다중 상속이 안 돼서 확장성 떨어짐
 * --> 즉, 골격 클래스를 통해 인터페이스 기반 설계는 유지하면서도, 필요한 구현은 추상 클래스로 한 번에 제공할 수 있음
 */
@Slf4j
public abstract class AbstractVehicle implements Vehicle{
    @Override
    public void start() {
        log.debug("시동을 겁니다.");
    }

    @Override
    public void stop() {
        log.debug("멈춥니다.");
    }

    // move() 메서드는 서브 클래스에서 구현
}
