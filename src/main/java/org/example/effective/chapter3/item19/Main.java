package org.example.effective.chapter3.item19;

public class Main {
    /**
     * 상속을 고려해 설계하고 문서화하라. 그러지 않았다면 상속을 금지하라
     * - 재정의가 가능한 메소드는 내부적으로 어떻게 이용하는지 문서로 남겨야한다.
     * - 상위클래스의 생성자 메소드에서 재정의가 가능한 함수를 사용하면 안됨
     * - 클래스의 내부 동작 과정 중간에 끼어들 수 있는 훅을 잘 선별하여 protected 메서드로 공개해야한다
     * - 상속용으로 설계하지 않은 클래스는 상속 금지
     */
    public static void main(String[] args) {

        //상위클래스(Super)의 생성자 메소드에서 재정의가 가능한 함수를 사용하면 안됨
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
