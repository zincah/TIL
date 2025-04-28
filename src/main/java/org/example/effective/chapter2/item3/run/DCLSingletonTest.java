package org.example.effective.chapter2.item3.run;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter2.item3.DCLSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public class DCLSingletonTest {
    public static void main(String[] args) throws Exception{
        DCLSingleton singleton1 = DCLSingleton.getInstance();

        // 직렬화
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dcl_singleton.ser"));
        oos.writeObject(singleton1);
        oos.close();

        // 역직렬화
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dcl_singleton.ser"));
        DCLSingleton singleton2 = (DCLSingleton) ois.readObject();
        ois.close();

        if(singleton1 == singleton2) {
            log.info("동일한 싱글톤 객체 => 역직렬화 문제 없음");
        }else{
            log.info("동일한 싱글톤 객체x");
        }

    }
}
