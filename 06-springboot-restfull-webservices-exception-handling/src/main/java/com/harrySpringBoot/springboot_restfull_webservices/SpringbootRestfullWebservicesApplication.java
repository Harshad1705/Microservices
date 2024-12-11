package com.harrySpringBoot.springboot_restfull_webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Implementing Exception Handling
// - create ErrorDetails.java
// - create CustomException like EmailAlreadyExistsExceptipn or ResourceNotFoundException
// - use in service where required
// - implement CustomException in GlobalExceptionHandler class

@SpringBootApplication
public class SpringbootRestfullWebservicesApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
		System.out.println("Started");
	}

}
