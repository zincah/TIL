package org.example.effective.chapter4.item15.nested;

import lombok.extern.slf4j.Slf4j;

/**
 * package-private 톱레벨 클래스나 인터페이스는 이를 사용하는 클래스 안에 private static으로 중첩시켜보자
 *
 * - Helper클래스가 MyService에서만 사용되는 보조클래스라면, 톱레벨 클래스로 만들지 말고
 * 그 클래스를 사용하는 주요 클래스 안에 private static 중첩 클래스로 넣으면서
 * 캡슐화 강화, 코드 응집도 증가, 패키지 오염 방지 등의 효과를 누릴 수 있다.
 */
@Slf4j
public class MyService {

    public void doWork(){
        Helper.help();
    }

    private static class Helper{
        static void help(){
            log.error("helping..");
        }
    }
}
