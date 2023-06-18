package com.program.gatepassservice.controller;

import com.program.gatepassservice.dto.CustomerDetailsDto;
import com.program.gatepassservice.service.GatepassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gatepass")
public class GatePassController {

    @Autowired
    private GatepassService gatepassService;
    @PostMapping
    public CustomerDetailsDto createPass(@RequestBody CustomerDetailsDto customerDetailsDto) {
//        System.out.println(customerDetailsDto);
        gatepassService.createGatePass(customerDetailsDto);
        return customerDetailsDto;
    }

    @GetMapping
    public List<CustomerDetailsDto> getCreatedPass(){
        return gatepassService.getCreatedPass();
    }
}
