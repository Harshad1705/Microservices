package com.harrySpringBoot.springboot_restfull_webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

// Implement Spring document - openapi
// - add dependency
// - define general information in SpringbootRestfullWebservicesApplication class
// - add @Tag,@Operation,@ApiResponse in UserController class
// - add @Schema in UserDto

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "Spring Boot Rest Api Documentation",
			description = "Spring Boot Rest Api Documentation",
			version = "v1.0",
			contact = @Contact(
				name = "Harry",
				email = "hp85247@gmail.com",
				url = "https://github.com/Harshad1705"
			),
				license = @License(
				name = "Apache 2.0",
				url = "https://github.com/Harshad1705"		
				)
				
			),
		externalDocs = @ExternalDocumentation(
					description = "Spring Boot User Management Documentation",		
					url = "https://github.com/Harshad1705"		
		)
)
public class SpringbootRestfullWebservicesApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
		System.out.println("Started");
	}

}
