package com.harrySpringBoot.employee_service.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harrySpringBoot.employee_service.dto.APIResponseDto;
import com.harrySpringBoot.employee_service.dto.DepartmentDto;
import com.harrySpringBoot.employee_service.dto.EmployeeDto;
import com.harrySpringBoot.employee_service.entity.Employee;
import com.harrySpringBoot.employee_service.exception.EmailAlreadyExistsException;
import com.harrySpringBoot.employee_service.exception.ResourceNotFoundException;
import com.harrySpringBoot.employee_service.repository.EmployeeRepository;
import com.harrySpringBoot.employee_service.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestTemplate restTemplate;

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

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employyes not found with : " + employeeId));

        // call department api        
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
    
}
