package org.example.effective.chapter2.item3.run;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter2.item3.HolderSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public class HolderSingletonTest {
    public static void main(String[] args) throws Exception{
        HolderSingleton singleton1 = HolderSingleton.getInstance();
        singleton1.printLogging();

        // 직렬화
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("holder_singleton.ser"));
        oos.writeObject(singleton1);
        oos.close();

        // 역직렬화
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("holder_singleton.ser"));
        HolderSingleton singleton2 = (HolderSingleton) ois.readObject();
        singleton2.printLogging();
        ois.close();

        if(singleton1 == singleton2) {
            log.info("동일한 싱글톤 객체 => 역직렬화 문제 없음");
        }else{
            log.info("동일한 싱글톤 객체x");
        }
    }
}
