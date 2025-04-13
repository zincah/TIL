package org.example.effective.builder;

import lombok.extern.slf4j.Slf4j;
import static org.example.effective.builder.User.Authority.*;

@Slf4j
public class UserBuild {

    /**
     * Builder 패턴 활용 예시
     * - 빌더 패턴은 계층 적으로 설계된 클래스와 함께 쓰기에 좋다.
     * - 사용자 클래스를 상속받는 관리자 클래스와 고객 클래스를 선언하여 예제 작성
     * --> 사용자 클래스 : create, update, delete, select 권한 정보를 enum 클래스로 소유
     * --> 관리자 클래스 : 관리자 ID 필수값 필요
     * --> 고객  클래스 : 고객 ID, 등급 필수값 필요
     * --> 그 외 사용자 클래스에 선언한 이메일, 이름, 이미지경로 정보는 선택적으로 선언해서 사용할 수 있음
     *
     * --> 빌더 객체는 불변 객체를 안전하게 만들기 위해 설계된 패턴으로써 한번 build() 해서 생성한 객체는 변경하지 않는 것이 원칙
     * --> 변경하고 싶으면 빌더를 복사해서 사용해야함
     */
    public static void main(String[] args) {

        log.info("== 관리자 mode ==");
        Manager manager = new Manager.Builder("EM01")
                .addAuthority(CREATE).addAuthority(UPDATE).addAuthority(DELETE).addAuthority(SELECT)
                .name("콩나물")
                .email("abcd123@naver.com")
                .build();
        log.info("관리자 정보 {}", manager.toString());

        log.info("== 고객 mode ==");
        Customer customer = new Customer.Builder(Customer.Level.BRONZE, "CU01")
                .addAuthority(SELECT)
                .email("customer1@daum.net")
                .build();
        log.info("고객 정보 {}", customer.toString());

        log.info("== 고객 등급 변경 ==");
        Customer updateCustomer = customer.toBuilder()
                .level(Customer.Level.SILVER)
                .build();

        log.info("고객 정보 {}", updateCustomer.toString());

    }
}
