package com.harrySpringBoot.springboot_restfull_webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Implement Actuators
// - add dependency
// - change in application.properties

@SpringBootApplication
public class SpringbootRestfullWebservicesApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
		System.out.println("Started");
	}

}
