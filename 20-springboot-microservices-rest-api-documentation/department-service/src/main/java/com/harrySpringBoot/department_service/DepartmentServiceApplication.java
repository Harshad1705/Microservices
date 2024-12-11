package com.harrySpringBoot.department_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title="Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Harry Dev",
						email = "hp85247@gmail.com",
						url = "https://github.com/Harshad1705"
										
				),
				license = @License(
					name = "Apache 2.0",
					url = "https://github.com/Harshad1705"
				)
		),
		externalDocs = @ExternalDocumentation(
			description = "Department Service Docs",
			url = "https://www.linkedin.com/in/harshad-lande-0a1b41207/"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
		System.out.println("Started Department Service");
	}

}
