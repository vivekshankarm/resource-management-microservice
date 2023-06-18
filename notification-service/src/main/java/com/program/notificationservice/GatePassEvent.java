package com.program.notificationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatePassEvent {
    private String visitor;
    private String phoneNumber;
    private String meeting_person;
}
