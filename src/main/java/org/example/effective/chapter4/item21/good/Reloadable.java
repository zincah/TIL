package org.example.effective.chapter4.item21.good;

/**
 * 안전하게 디폴트 메서드를 확장하는 3가지 패턴
 * 3. 디폴트 메서드가 하기 전에 상태/권한/지원 여부 점검
 *
 * 디폴트 메서드는 인터페이스 안에 정의되지만, 모든 구현체가 그 기능을 지원하진 않을 수 있음
 * 이럴 때 instanceof로 조건 검사를 넣어 지원 여부를 런타임에 판단하면, 예외를 던져 명확하게 제한을 걸 수 있음
 */
public interface Reloadable {
    default String reload(){
        if(!(this instanceof Runnable)){
            // 현재 객체가 Runnable 인터페이스를 구현했는가 검증
            throw new UnsupportedOperationException("Reload not supported by this instance");
        }

        return "reloading...";
    }
}
