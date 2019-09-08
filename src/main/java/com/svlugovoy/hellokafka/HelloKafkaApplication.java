package com.svlugovoy.hellokafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HelloKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloKafkaApplication.class, args);
    }

}
