package org.example.effective.chapter6.item35;

public enum Ensemble {
    SOLO, DUET, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;


    //enum 상수는 해당 상수가 열거 타입에서 몇번째 인지 반환하는 ordinal 메서드가 있다.
    // 아래는 ordinal 메소드를 사용해서 몇명의 연주자인지 반환하는 함수
    public int numberOfMusicians() {
        // 단점
        // 상수 선업 순서를 바꾸는 순간 오작동 하는 함수다
        // 이미 사용중인 정수와 값이 같은 상수는 추가한 방법이 없다.
        // 4중주가 더이상 사용하지 않는 경우 dummy로 채워야 한다.
        return ordinal() + 1;
    }
}
