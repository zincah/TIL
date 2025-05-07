package org.example.effective.chapter4.item15.serializable;

import java.io.Serializable;

/**
 * Serializable을 구현한 클래스는 private 필드라도 외부에 공개 API처럼 동작할 수 있다.
 *
 * 필드를 private 으로 숨겨놨더라도 클래스가 Serializable을 구현했다면
 * 직렬화/역직렬화 과정에서 해당 필드가 외부에 노출될 가능성이 있다는 뜻
 *
 * 따라서 직렬화 가능한 클래스의 모든 필드는 사실상 공개 API처럼 조심해서 설계해야 한다.
 */
public class User implements Serializable {
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
