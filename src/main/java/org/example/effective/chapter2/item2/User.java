package org.example.effective.chapter2.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class User {

    // 필수 매개변수
    public enum Authority {CREATE, UPDATE, DELETE, SELECT};
    final Set<Authority> authorities;

    // 선택 매개변수
    public String name;
    public String email;
    public String imgUrl;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Authority> authorities = EnumSet.noneOf(Authority.class);
        public T addAuthority(Authority authority){
            authorities.add(Objects.requireNonNull(authority));
            return self();
        }

        private String name;
        private String email;
        private String imgUrl;

        public T name(String name){
            this.name = name;
            return self();
        }

        public T email(String email){
            this.email = email;
            return self();
        }

        public T imgUrl(String imgUrl){
            this.imgUrl = imgUrl;
            return self();
        }

        abstract User build();

        // self()가 this(Builder)를 return self()를 함으로써 정확한 하위 타입(Builder)으로 캐스팅 없이 리턴해주기 위한 메소드 : 메서드 체이닝
        protected abstract T self();

        public T from(User user) {
            this.authorities = EnumSet.copyOf(user.authorities);
            this.name = user.name;
            this.email = user.email;
            this.imgUrl = user.imgUrl;
            return self();
        }
    }

    public User(Builder<?> builder) {
        authorities = builder.authorities.clone();
        this.name = builder.name;
        this.email = builder.email;
        this.imgUrl = builder.imgUrl;
    }
}
