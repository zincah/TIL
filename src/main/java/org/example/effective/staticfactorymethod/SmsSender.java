package org.example.effective.staticfactorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsSender implements MessageSender{
    @Override
    public void send(String to, String message) {
        log.debug("SMS to {}: {}", to, message);
    }
}
