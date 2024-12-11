package com.harrySpringBoot.springboot_restfull_webservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Implementing ModelMapper Library to convert User JPA into User DTO and User DTO into User JPA
@SpringBootApplication
public class SpringbootRestfullWebservicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
		System.out.println("Started");
	}

}
