package org.example.effective.chapter2.item1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsSender implements MessageSender{
    @Override
    public void send(String to, String message) {
        log.debug("SMS to {}: {}", to, message);
    }
}
