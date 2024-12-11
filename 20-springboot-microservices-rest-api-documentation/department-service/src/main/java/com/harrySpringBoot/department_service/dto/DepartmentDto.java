package com.harrySpringBoot.department_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
    description = "DepartmentDTO Model Information"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;

    @Schema(description = "Department Name")
    @NotEmpty(message = "Department name should not be null or empty")
    @NotBlank(message = "Department name should not be null or empty")
    private String departmentName;
    
    @Schema(description = "Department Description")
    @NotEmpty(message = "Department description should not be null or empty")
    @NotBlank(message = "Department description should not be null or empty")
    private String departmentDescription;
    
    @Schema(description = "Department Code")
    @NotEmpty(message = "Department code should not be null or empty")
    @NotBlank(message = "Department code should not be null or empty")
    private String departmentCode;

}
