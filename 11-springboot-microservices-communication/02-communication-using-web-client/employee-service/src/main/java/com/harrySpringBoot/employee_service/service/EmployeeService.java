package com.harrySpringBoot.employee_service.service;


import com.harrySpringBoot.employee_service.dto.APIResponseDto;
import com.harrySpringBoot.employee_service.dto.EmployeeDto;


public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);

}
