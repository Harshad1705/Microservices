package com.harrySpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsumerApplication {
    public static void main(String[] args) {
		SpringApplication.run(SpringBootConsumerApplication.class, args);
        System.out.println("SpringBootConsumer started");
    }
}