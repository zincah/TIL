package org.example.effective.chapter8.item54;

import java.util.ArrayList;
import java.util.List;

// 배열인 경우 new Item[0]과 같은 방법으로 빈 배열을 할당해야한다.
// new Item[0]을 static 변수로 선언하여 사용하면 최적화가 가능하다.
public class Inventory {
    private static final Item[] EMPTY_ITEMS = new Item[0]; // 재사용할 빈 배열

    private final List<Item> items = new ArrayList<>();

    public Item[] getItems() {
        if (items.isEmpty()) {
            return EMPTY_ITEMS; //빈 배열 재사용
        }

        return items.toArray(new Item[items.size()]);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Item[] items = inventory.getItems();
        System.out.println("items.length = " + items.length); // 0
    }
}





class Item {
    private final String name;
    private final int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // toString (디버깅용)
    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + price + '}';
    }
}