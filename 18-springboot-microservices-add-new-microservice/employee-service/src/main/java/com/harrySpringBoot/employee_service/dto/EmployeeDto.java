package com.harrySpringBoot.employee_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "Employee first name should not be null or empty")
    @NotBlank(message = "Employee first name should not be null or empty")
    private String firstName;

    @NotEmpty(message = "Employee last name should not be null or empty")
    @NotBlank(message = "Employee last name should not be null or empty")
    private String lastName;

    @NotEmpty(message = "Employee email should not be null or empty")
    @Email(message = "Employee email should be valid")
    private String email;

    private String departmentCode;

    private String organizationCode;
}
