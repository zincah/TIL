package org.example.effective.chapter7.item47;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 입력 리스트의 (연속적인) 부분리스트를 모두 반환하는 메서드
 * (a, b, c)
 * prefix: (a), (a, b), (a, b, c)
 * subfix: (a, b, c), (b, c), (c)
 *
 * 어떤 리스트의 부분리스트는 프리픽스와 서픽스에 빈 리스트 하나 추가한 것
 */
public class SubLists {
    public static <E>Stream<List<E>> of (List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes (List<E> list) {
        return IntStream.rangeClosed(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }
}
