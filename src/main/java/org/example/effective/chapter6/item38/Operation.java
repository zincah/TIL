package org.example.effective.chapter6.item38;

/**
 * enum 클래스는 상속 및 확장이 불가능하다.
 * public enum -> public final class 로 취급되기 때문이다.
 *
 * 하지만 enum 클래스를 확장시켜서 사용하고 싶다면 인터페이스를 사용해서 이 요건을 충족시켜줄 수 있다.
 */
public interface Operation {
    double apply(double x, double y);
}
