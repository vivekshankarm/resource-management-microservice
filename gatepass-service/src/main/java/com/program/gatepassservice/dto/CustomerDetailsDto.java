package com.program.gatepassservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailsDto {

    private String visitor;
    private String phoneNumber;
    private String description;
    private String meetingPerson;
}
