package org.example.effective.item5_dependencyinjection.dictionary;

import org.example.effective.item5_dependencyinjection.Dictionary;

public class DefaultDictionary implements Dictionary {

    @Override
    public boolean contains(String word) {
        return word.equals("hello");
    }
}
