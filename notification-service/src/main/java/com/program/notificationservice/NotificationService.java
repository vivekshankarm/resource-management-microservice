package com.program.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NotificationService {
    public static void main(String[] args) {
        SpringApplication.run(NotificationService.class,args);
        System.out.println("Hello world!");
    }
}