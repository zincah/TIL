package org.example.effective.chapter2.item1;

import lombok.extern.slf4j.Slf4j;

/**
 * 정적 팩터리 메서드 제공 클래스
 */

@Slf4j
public class MessageSenderFactory {

    public static MessageSender of(String type){
        if("sms".equalsIgnoreCase(type)){
            return new SmsSender();
        }else if("email".equalsIgnoreCase(type)){
            return new EmailSender();
        }
        throw new IllegalArgumentException("Unknown message sender type : " + type);
    }
}
