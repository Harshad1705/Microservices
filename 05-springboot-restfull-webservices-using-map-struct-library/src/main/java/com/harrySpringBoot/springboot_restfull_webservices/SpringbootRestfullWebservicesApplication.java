package com.harrySpringBoot.springboot_restfull_webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Implementing MapStruct Library to convert User JPA into User DTO and User DTO into User JPA
@SpringBootApplication
public class SpringbootRestfullWebservicesApplication {

	// @Bean
	// public ModelMapper modelMapper() {
	// 	return new ModelMapper();
	// }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
		System.out.println("Started");
	}

}
