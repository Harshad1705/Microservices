package com.harrySpringBoot.employee_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	// @Bean
	// public RestTemplate restTemplate() {
	// 	return new RestTemplate();
	// }	

	// @Bean
	// public WebClient webClient() {
	// 	return WebClient.builder().build();
	// }
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		System.out.println("Started Employee Service");
	}

}
