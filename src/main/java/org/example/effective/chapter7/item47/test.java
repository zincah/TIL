package org.example.effective.chapter7.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Java의 Stream API는 iteration을 지원하지 않음
 * Iterator, Iterable, resultSet 같은 반복 객체는 직접 Stream을 사용할 수 없음
 * 이런 반복 가능한 요소들을 스트림처럼 사용할 수 있으면 기능 재사용과 조합이 훨씬 쉬워짐
 * 따라서 Iterator/Iterable을 Stream으로 변환하는 "어댑터 메서드"를 만들어 활용하길 권장
 *
 */
public class test {
    public static void main(String[] args) {

        // 컴파일 에러
        //for (ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {}

        // 지저분한 코드
        for (ProcessHandle ph : (Iterable<ProcessHandle>)
                ProcessHandle.allProcesses()::iterator) {
            //
        }

        // iterableOf 어댑터 사용
        for (ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())){
            //
        }
    }

    // Stream<E>를 Iterable<E>로 중개해주는 어댑터
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    // Iterable<E>를 Stream<E>로 중개해주는 어댑터
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
