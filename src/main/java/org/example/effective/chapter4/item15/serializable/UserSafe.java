package org.example.effective.chapter4.item15.serializable;

import java.io.Serializable;

/**
 * transient 키워드로 직렬화 대상 제외하는 예제
 */
public class UserSafe implements Serializable {
    private String username;
    private transient String password;  // ✅ 직렬화에서 제외됨

    public UserSafe(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserSafe(username=" + username + ", password=" + password + ")";
    }
}
