package com.program.gatepassservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.program.gatepassservice.event.GatePassEvent;
import com.program.gatepassservice.model.CustomerDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.program.gatepassservice.dto.CustomerDetailsDto;
import com.program.gatepassservice.repository.GatePassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class GatepassService {

    @Autowired
    private GatePassRepository repo;
    @Autowired
    private ObjectMapper objectMapper;
    private final KafkaTemplate<String, GatePassEvent> kafkaTemplate;

    public void createGatePass(CustomerDetailsDto customerDetailsDto){
        CustomerDetails customerDetails = objectMapper.convertValue(customerDetailsDto, CustomerDetails.class);
//        System.out.println(customerDetails);
        repo.save(customerDetails);
        kafkaTemplate.send("notificationTopic",new GatePassEvent(customerDetailsDto.getVisitor(),customerDetails.getPhoneNumber(),customerDetails.getMeetingPerson()));
    }

    public List<CustomerDetailsDto> getCreatedPass(){
        List<CustomerDetails> customerDetailsList = repo.findAll();
        return objectMapper.convertValue(customerDetailsList,objectMapper.getTypeFactory().constructCollectionType(List.class, CustomerDetailsDto.class));
    }
}
