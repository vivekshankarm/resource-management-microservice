package com.program.gatepassservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatepassApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatepassApplication.class,args);
        System.out.println("Hello world!");
    }
}