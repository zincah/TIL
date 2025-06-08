package org.example.effective.chapter5.item26;
import java.util.ArrayList;
import java.util.List;

public class B_WildcardVsObjectList {

    // List<?> - accepts any type of list (읽기 전용)
    // 요소 추가 불가능
    public static void printAnyList(List<?> list) {
        System.out.println("printAnyList:");
        for (Object item : list) {
            System.out.println("  " + item);
        }

        // list.add("new item"); // Compile error: can't add anything
    }

    // List<Object> - accepts only List<Object>
    //List<String>이나 List<Integer> 등은 불가능
    public static void printObjectList(List<Object> list) {
        System.out.println("printObjectList:");
        for (Object item : list) {
            System.out.println("  " + item);
        }

        list.add("Added to List<Object>"); // You can add
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");

        List<Object> objectList = new ArrayList<>();
        objectList.add("One");
        objectList.add(2);

        // OK: List<String> is acceptable
        printAnyList(stringList);

        // Compile error: List<String> is not List<Object>
        // printObjectList(stringList); // UNCOMMENT to see the error

        // OK: List<Object> works for both methods
        printAnyList(objectList);
        printObjectList(objectList);
    }
}
