package org.example.effective.chapter8.item52;

import java.util.List;

class Wine {
    String name() {
        return "wine";
    }
}

class SparklingWine extends Wine {
    String name() {
        return "sparkling";
    }
}

class Champagne extends Wine {
    String name() {
        return "champagne";
    }
}
public class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = List.of(
                new Wine(), new SparklingWine(), new Champagne()
        );
        for (Wine w : wineList) {
            System.out.println(w.name());
        }
    }
}
