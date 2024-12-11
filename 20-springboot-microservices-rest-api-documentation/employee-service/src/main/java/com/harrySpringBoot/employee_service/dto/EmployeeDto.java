package com.harrySpringBoot.employee_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
    description = "EmployeeDTO Model Information"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    @Schema(description = "Employee First Name")
    @NotEmpty(message = "Employee first name should not be null or empty")
    @NotBlank(message = "Employee first name should not be null or empty")
    private String firstName;
    
    @Schema(description = "Employee Last Name")
    @NotEmpty(message = "Employee last name should not be null or empty")
    @NotBlank(message = "Employee last name should not be null or empty")
    private String lastName;
    
    @Schema(description = "Employee Email Address")
    @NotEmpty(message = "Employee email should not be null or empty")
    @Email(message = "Employee email should be valid")
    private String email;
    
    @Schema(description = "Employee's Department Code")
    private String departmentCode;
    
    @Schema(description = "Employee's Organization Code")
    private String organizationCode;
}
