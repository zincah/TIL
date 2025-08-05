package org.example.effective.chapter8.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// List<E> 인터페이스가 remove(Object)와 remove(int)를 다중정의함
// 다음과 같은 상황이 발생 할 수 있음 주의해야함
public class SetListGood {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            //list.remove(i); //다중정의된 remove(int index)사용
            list.remove((Integer) i);
        }
        System.out.println(set + " " + list);
    }
}
