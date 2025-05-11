package org.example.effective.chapter4.item20.skeleton;

// 믹스인 인터페이스 = 이 인터페이스를 구현한 클래스는 선택적으로 추가 가능
// default method 를 선언한 인터페이스
public interface ElectricPowered {
    default String charge(){
        return "전기를 충전합니다.";
    }

    default int batteryStatus(){
        return 100;
    }
}
