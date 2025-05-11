package org.example.effective.chapter4.item20;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog implements Animal{
    @Override
    public String sound() {
        return "멍멍";
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        log.debug(dog.sound());
        log.debug(dog.sleep());
    }
}
