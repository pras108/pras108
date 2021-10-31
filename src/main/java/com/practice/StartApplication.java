package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
        System.out.println("Main class");
        SpringApplication.run(StartApplication.class, args);
    }
}
