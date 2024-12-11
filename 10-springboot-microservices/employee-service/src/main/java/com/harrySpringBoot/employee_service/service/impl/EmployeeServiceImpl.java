package com.harrySpringBoot.employee_service.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee optionaEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
        
        if (optionaEmployee != null) {
            throw new EmailAlreadyExistsException("Email already exists for employee");
        }

        // Employee employee = new Employee(
        //             employeeDto.getId(),
        //             employeeDto.getFirstName(),
        //             employeeDto.getLastName(),
        //             employeeDto.getEmail()
        // );
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        // EmployeeDto savedEmployeeDto = new EmployeeDto(
        //         savedEmployee.getId(),
        //         savedEmployee.getFirstName(),
        //         savedEmployee.getLastName(),
        //         savedEmployee.getEmail()
        // );
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        
        return savedEmployeeDto;       
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee optiallEmployee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employyes not found with : " + employeeId));


        // EmployeeDto employeeDto = new EmployeeDto(
        //     employee.getId(),
        //     employee.getFirstName(),
        //     employee.getLastName(),
        //     employee.getEmail()
        // );
        EmployeeDto employeeDto = modelMapper.map(optiallEmployee, EmployeeDto.class);

        return employeeDto;
    }
    
}
