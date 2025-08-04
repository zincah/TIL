package org.example.effective.chapter8.item55;

import java.util.Optional;

/**
 * Optional 사용 안 좋은 예
 * - Optional 매개변수 사용하기
 */
public class OptionalParameterBad {

    // optional 매개변수는 혼란을 유발할 수 있음, 호출자가 해당 메소드를 어떻게 사용해야하는지 헷갈리게 됨
    public void setNickname(Optional<String> nickname){

        // nickname이 null일 수도 있고, optional.empty()일 수도 있기때문에 모두 검증해줘야함.
        if(nickname != null && nickname.isPresent()){
            // optional은 null 대체용인데 공존하게 됨 -> 철학 위배
            System.out.println("nickname : " + nickname.get());
        }else{
            System.out.println("nickname x");
        }
    }

    public static void main(String[] args) {
        OptionalParameterBad bad = new OptionalParameterBad();

        bad.setNickname(Optional.of("ahyeon"));
        bad.setNickname(Optional.empty());
        bad.setNickname(null); // Nullpointerexception 위험이 있음
    }
}
