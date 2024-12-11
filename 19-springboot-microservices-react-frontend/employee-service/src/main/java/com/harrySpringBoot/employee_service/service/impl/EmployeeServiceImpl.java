package com.harrySpringBoot.employee_service.service.impl;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.harrySpringBoot.employee_service.dto.APIResponseDto;
import com.harrySpringBoot.employee_service.dto.DepartmentDto;
import com.harrySpringBoot.employee_service.dto.EmployeeDto;
import com.harrySpringBoot.employee_service.dto.OrganizationDto;
import com.harrySpringBoot.employee_service.entity.Employee;
import com.harrySpringBoot.employee_service.exception.EmailAlreadyExistsException;
import com.harrySpringBoot.employee_service.exception.ResourceNotFoundException;
import com.harrySpringBoot.employee_service.repository.EmployeeRepository;
import com.harrySpringBoot.employee_service.service.EmployeeService;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final  Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee optionaEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if (optionaEmployee != null) {
            throw new EmailAlreadyExistsException("Email already exists for employee");
        }

        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);

        return savedEmployeeDto;
    }

    // @CircuitBreaker(name = "${spring.application.name}" , fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}" , fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById() method");


        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employyes not found with : " + employeeId));

        // REST CALL from employee service to department service
        DepartmentDto departmentDto = webClient.get()
        .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
        .bodyToMono(DepartmentDto.class).block();
        
        
        // REST CALL from employee service to organization service
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organization/" + employee.getOrganizationCode()).retrieve()
                .bodyToMono(OrganizationDto.class).block();



        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        // add organizationdto to APIResponse
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;
    }
    

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
        
        LOGGER.info("inside getDefaultDepartment() method");

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employyes not found with : " + employeeId));

        
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("Null");
        departmentDto.setDepartmentDescription("Null");
        departmentDto.setDepartmentCode("Null");


        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    
}
