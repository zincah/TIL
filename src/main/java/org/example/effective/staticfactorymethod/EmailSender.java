package org.example.effective.staticfactorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailSender implements MessageSender{

    @Override
    public void send(String to, String message) {
        log.debug("EMAIL to {}: {}", to, message);
    }
}
