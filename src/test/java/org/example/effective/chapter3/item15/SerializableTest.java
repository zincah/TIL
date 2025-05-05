package org.example.effective.chapter3.item15;

import lombok.extern.slf4j.Slf4j;
import org.example.effective.chapter3.item15.serializable.User;
import org.example.effective.chapter3.item15.serializable.UserSafe;
import org.junit.jupiter.api.Test;

import java.io.*;

@Slf4j
public class SerializableTest {

    // 1. 직렬화로 인해 private 데이터가 외부에 노출되는 경우 -> 파일을 열었을 때 비밀번호 확인 가능
    @Test
    public void userUnSafe()throws IOException {
        User user = new User("ahyeon", "1234lay");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));
        oos.writeObject(user);
        oos.close();
    }

    @Test
    public void userSafe()throws IOException{
        UserSafe user = new UserSafe("ahyeon", "1234lay");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user_safe.ser"));
        oos.writeObject(user);
        oos.close();
    }

}
