package org.example.effective.chapter8.item55;

import java.util.List;
import java.util.Optional;

/**
 * Optional 사용 안 좋은 예
 * - Optional을 컬렉션 요소로 사용하기
 */
public class OptionalInListBad {
    public static void main(String[] args) {

        // Optional 요소가 들어간 리스트
        List<Optional<String>> optionalWrappingList = List.of(
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B")
        );

        // Optional 리스트 조회
        for (Optional<String> opt : optionalWrappingList) {

            // 설계가 불필요하게 복잡해짐
            opt.ifPresentOrElse(
                    val -> System.out.println("Value: " + val),
                    () -> System.out.println("비어 있음")
            );
        }

        // 1. 애초에 값이 없으면 list에 넣지 않으면 됨
        // 2. list 요소가 없으면 null 체크를 진행하면 됨
        List<String> list = List.of("A", "B");
//        List<String> list = null;

        if(!list.isEmpty()){
            for (String str : list){
                System.out.println("Value : " + str);
            }
        }
    }
}
