package org.example.effective.chapter6.item41.reason1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.*;

@Slf4j
public class NoMarker {
    String key;
    int index;

    public NoMarker(String key, int index) {
        this.key = key;
        this.index = index;
    }

    public static void main(String[] args){
        NoMarker noMarker = new NoMarker("abc", 1);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("noMarker.obj"))){

            // Serializable을 구현하지 않은 객체는 jvm이 직렬화를 거부하기에 해당 메소드에서 에러 발생
            // ObjectOutputStream에 검증하는 부분이 있음
            // 의도하지 않은 객체 저장/전송을 방지하는 안전장치 역할
            out.writeObject(out);
        }catch (IOException e){
            log.error(ExceptionUtils.getStackTrace(e));
        }

    }
}
