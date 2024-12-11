package com.harrySpringBoot.department_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;

    @NotEmpty(message = "Department name should not be null or empty")
    @NotBlank(message = "Department name should not be null or empty")
    private String departmentName;
    
    @NotEmpty(message = "Department description should not be null or empty")
    @NotBlank(message = "Department description should not be null or empty")
    private String departmentDescription;
    
    @NotEmpty(message = "Department code should not be null or empty")
    @NotBlank(message = "Department code should not be null or empty")
    private String departmentCode;

}
