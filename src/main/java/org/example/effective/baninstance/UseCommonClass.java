package org.example.effective.baninstance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UseCommonClass {

    public static void main(String[] args) {

        int a = 6;
        int b = 5;

//        CommonUtil commonUtil = new CommonUtil(); // <-- 접근이 안되므로 클래스가 인스턴스화 되지 않는다.

        log.info("{} + {} = {}", a, b, CommonUtil.add(a, b));
        log.info("{} - {} = {}", a, b, CommonUtil.minus(a, b));
    }
}
