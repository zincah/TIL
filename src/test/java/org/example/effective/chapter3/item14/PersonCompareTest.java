package org.example.effective.chapter3.item14;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class PersonCompareTest {

    public static void addPersonData(List list){
        list.add(new Person("Alice", 30, 155.50));
        list.add(new Person("Alice", 45, 168.77));
        list.add(new Person("Bob", 25, 180.00));
        list.add(new Person("Charlie", 35, 169.50));
        list.add(new Person("Charlie", 35, 172.10));
    }

    // comparable 사용
    @Test
    public void comparableTest(){
        List<Person> list = new ArrayList<>();
        addPersonData(list);

        Collections.sort(list);

        for(Person person : list){
            log.debug(person.toString());
        }
    }

    // comparator 사용
    @Test
    public void comparatorTest(){
        List<Person> list = new ArrayList<>();
        addPersonData(list);

        // 예제 사용하기

    }
}
