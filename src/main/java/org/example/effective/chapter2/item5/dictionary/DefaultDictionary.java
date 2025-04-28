package org.example.effective.chapter2.item5.dictionary;

import org.example.effective.chapter2.item5.Dictionary;

public class DefaultDictionary implements Dictionary {

    @Override
    public boolean contains(String word) {
        return word.equals("hello");
    }
}
