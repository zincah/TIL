package my.wonseok.chapter02.item19;

import java.time.Instant;

public class Sub extends Super {
    private final Instant instant;
    Sub() {
        instant = Instant.now();
    }

    //Super가 생성될때 아래 재정의된 함수 사용. instant는 초기화 전이라 null 발생
    @Override
    public void overrideMe() {
        System.out.println("Sub.overrideMe() at " + instant);
    }
}
