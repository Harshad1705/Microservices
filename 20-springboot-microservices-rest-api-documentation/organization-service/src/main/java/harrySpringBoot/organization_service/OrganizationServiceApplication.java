package harrySpringBoot.organization_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title="Organization Service REST APIs",
				description = "Organization Service REST APIs Documentation",
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
			description = "Organization Service Docs",
			url = "https://www.linkedin.com/in/harshad-lande-0a1b41207/"
		)
)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
		System.out.println("Started Organization Service");
	}

}
