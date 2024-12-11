package com.harrySpringBoot.springboot_restfull_webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Implement validation
// - add validation in UserDto
// - add @Valid in createUser() and updateUser() in controller
// - override handleMethodArgumentNotValid() in GlobalException class


@SpringBootApplication
public class SpringbootRestfullWebservicesApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
		System.out.println("Started");
	}

}
