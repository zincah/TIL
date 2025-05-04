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
        list.add(new Person("Alice", 45, 155.50));
        list.add(new Person("Bob", 30, 180.00));
        list.add(new Person("Charlie", 65, 169.50));
        list.add(new Person("Charlie", 45, 172.10));
        list.add(new Person("Dobby", 30, 180.00));
    }

    public static void printList(List<Person> list){
        for(Person person : list){
            log.debug(person.toString());
        }
    }

    // comparable 사용
    @Test
    public void comparableTest(){
        List<Person> list = new ArrayList<>();
        addPersonData(list);

        Collections.sort(list);
        printList(list);
    }

    // comparator 사용 1
    @Test
    public void comparatorTest1(){
        List<Person> list = new ArrayList<>();
        addPersonData(list);

        /** 이름 오름차순 -> 키 오름차순 -> 나이 내림차순 **/
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.getName().compareTo(o2.getName());
                if(result == 0){
                    result = Double.compare(o1.getHeight(), o2.getHeight());
                    if(result == 0){
                        result = Integer.compare(o2.getAge(), o1.getAge());
                    }
                }

                return result;
            }
        });

        printList(list);
    }

    // comparator 사용 2
    @Test
    public void comparatorTest2(){
        List<Person> list = new ArrayList<>();
        addPersonData(list);

        /** 나이 내림차순 -> 키 오름차순 -> 이름 내림차순 **/
        Comparator<Person> compares =
                Comparator.comparingInt(Person::getAge) // (Person pn) -> pn.getAge()
                        .reversed()
                        .thenComparingDouble(Person::getHeight)
                        .thenComparing(
                                Comparator.comparing(Person::getName).reversed()
                        );

        Collections.sort(list, compares);
        printList(list);
    }
}
