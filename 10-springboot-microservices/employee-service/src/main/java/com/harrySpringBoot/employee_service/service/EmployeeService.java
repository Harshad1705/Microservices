package com.harrySpringBoot.employee_service.service;


import com.harrySpringBoot.employee_service.dto.EmployeeDto;


public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

}
