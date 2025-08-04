package org.example.effective.chapter8.item55;

import java.util.Optional;

/**
 * Optional 사용 안 좋은 예
 * - Optional 필드로 사용
 * : 상태를 저장히가 위한 구조가 아님
 */
public class OptionalFieldBad {

    // 직렬화나 jackson, jpa등의 프레임워크에서는 optional을 잘 지원하지 않음.
    private Optional<String> nickname = Optional.empty();

    public Optional<String> getNickname(){
        return nickname;
    }

    public void setNickname(String name){
        this.nickname = Optional.ofNullable(name);
    }

    public static void main(String[] args) {
        OptionalFieldBad bad = new OptionalFieldBad();
        bad.setNickname("ahyeon");

        // 값이 있을 수도 있고 없을 수도 있다는 걸 필드수준에서 표현하는 건 지나친 표현, 값이 없을 수 있음은 내부 설계로 처리할 일
        bad.getNickname().ifPresent(name -> System.out.println("nickname : " + name));
    }

}
