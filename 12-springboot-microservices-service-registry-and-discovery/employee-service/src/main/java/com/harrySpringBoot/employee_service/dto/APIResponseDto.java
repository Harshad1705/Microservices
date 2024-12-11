package com.harrySpringBoot.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

    private EmployeeDto employee;

    private DepartmentDto department;
}
