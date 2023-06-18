package com.program.notificationservice.service;

import com.twilio.Twilio;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
@NoArgsConstructor
public class SMSService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    public void sendSMS(String phoneNumber, String message) {
        // Initialize the Twilio client
        Twilio.init(accountSid, authToken);

        // Send the SMS using the Twilio API
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber("your-twilio-phone-number"),
                message
        ).create();
    }
}

