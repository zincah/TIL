package org.example.effective.chapter6.item41.reason1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.*;

/**
 * 마커 인터페이스는 이를 구현한 클래스의 인스턴스를 구분하는 타입으로 쓸 수 있다. (마커 애너테이션은 x)
 */
@Slf4j
public class Marker implements Serializable {
    String key;
    int index;

    public Marker(String key, int index) {
        this.key = key;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Marker{" +
                "key='" + key + '\'' +
                ", index=" + index +
                '}';
    }

    public static void main(String[] args) {

        // 저장
        Marker marker1 = new Marker("abc", 1);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("marker.obj"))){
            out.writeObject(marker1);
        }catch (IOException e){
            log.error(ExceptionUtils.getStackTrace(e));
        }

        // 읽기
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("marker.obj"))){
            Marker marker2 = (Marker) in.readObject();
            System.out.println(marker2.toString());
        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }

    }
}
