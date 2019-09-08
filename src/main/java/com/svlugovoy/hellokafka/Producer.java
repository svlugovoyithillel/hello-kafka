package com.svlugovoy.hellokafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class Producer {

    private static final String TOPIC = "hello_users";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }

    @Scheduled(fixedDelay = 30000L, initialDelay = 30000L)
    public void sendScheduledMessage() {
        String message = LocalDateTime.now().toString();
        log.info(String.format("*** #### -> Scheduled message -> %s ***", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}