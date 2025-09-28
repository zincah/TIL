package org.example.effective.chapter9.item67;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 내부 구현체를 자유롭게 변경할 수 있음 -> 유연하게 성능 최적화 가능
 */
public class BetterListTest {

    public static void main(String[] args) {
        BetterList<String> arrayListVersion = new BetterList<>(new ArrayList<>());
        arrayListVersion.add("apple");
        arrayListVersion.add("banana");
        arrayListVersion.add("cherry");

        System.out.println("ArrayList 기반 BetterList: " + arrayListVersion);
        System.out.println("Contains 'banana'? " + arrayListVersion.contains("banana"));

        // LinkedList 기반으로 교체
        BetterList<String> linkedListVersion = new BetterList<>(new LinkedList<>());
        linkedListVersion.add("x");
        linkedListVersion.add("y");
        linkedListVersion.add("z");

        System.out.println("\nLinkedList 기반 BetterList: " + linkedListVersion);
        System.out.println("Size: " + linkedListVersion.size());
    }
}
