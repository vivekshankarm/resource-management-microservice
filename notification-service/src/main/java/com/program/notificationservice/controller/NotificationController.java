package com.program.notificationservice.controller;

import com.program.notificationservice.GatePassEvent;
import com.program.notificationservice.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

//    @Autowired
    private final SMSService smsService;

    public NotificationController(SMSService smsService) {
        this.smsService = smsService;
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(GatePassEvent gatePassEvent){
        System.out.println(gatePassEvent);
    }
}
