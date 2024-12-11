package com.harrySpringBoot.springboot_restfull_webservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "UserDto Model Information"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    
    private Long id;

    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "User first name should not be null or empty")
    @NotBlank(message = "User first name should not be null or empty")
    private String firstName;
    

    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "User last name should not be null or empty")
    @NotBlank(message = "User last name should not be null or empty")
    private String lastName;
    

    @Schema(
            description = "User Email Address"
    )
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "User email should be valid")
    private String email;
}
