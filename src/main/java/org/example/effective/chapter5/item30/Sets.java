package org.example.effective.chapter5.item30;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
