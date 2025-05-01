package org.example.effective.chapter3.item14;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return name + " (" + age + "세, " + height + "cm)";
    }

    /**
     * compareTo()는 하나의 클래스에 오직 하나만 존재하기 때문에:
     * - 항상 고정된 비교 방식만 제공
     * - 정렬 기준을 바꾸고 싶으면 클래스를 수정하거나 Comparator를 따로 만들어야 함.
     * - 다른 기준이 필요하면 기존 compareTo를 덮어쓰거나 Comparator를 써야 함.
     */

    /** 이름 오름차순 -> 나이 내림차순 -> 키 내림차순 **/
    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.name);
        if(result == 0){
            result = Integer.compare(o.age, this.age);
            if(result == 0){
                result = Double.compare(o.height, this.height);
            }
        }

        return result;
    }
}
