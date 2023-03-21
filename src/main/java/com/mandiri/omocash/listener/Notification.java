package com.mandiri.omocash.listener;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "group-notif", topics = "omo-notification")
class Notification {

    @KafkaHandler
    void listen(String message) {
        System.out.println("MESSAGE: "+ message);
    }
}