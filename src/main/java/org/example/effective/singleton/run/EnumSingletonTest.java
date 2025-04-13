package org.example.effective.singleton.run;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.singleton.EnumSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public class EnumSingletonTest {

    public static void main(String[] args) throws Exception{

        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        singleton1.printLogging();

        // 직렬화
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enum_singleton.ser"));
        oos.writeObject(singleton1);
        oos.close();

        // 역직렬화
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enum_singleton.ser"));
        EnumSingleton singleton2 = (EnumSingleton) ois.readObject();
        singleton2.printLogging();
        ois.close();

        if(singleton1 == singleton2) {
            log.info("동일한 싱글톤 객체 => 역직렬화 문제 없음");
        }else{
            log.info("동일한 싱글톤 객체x");
        }

    }
}
