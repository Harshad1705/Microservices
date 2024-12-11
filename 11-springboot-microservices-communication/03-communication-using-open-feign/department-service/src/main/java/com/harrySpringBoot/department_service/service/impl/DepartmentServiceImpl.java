package com.harrySpringBoot.department_service.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harrySpringBoot.department_service.dto.DepartmentDto;
import com.harrySpringBoot.department_service.entity.Department;
import com.harrySpringBoot.department_service.exception.DepartmentCodeAlreadyExistsException;
import com.harrySpringBoot.department_service.exception.ResourceNotFoundException;
import com.harrySpringBoot.department_service.repository.DepartmentRepository;
import com.harrySpringBoot.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department optionalDepartment = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());

        if (optionalDepartment != null) {
            throw new DepartmentCodeAlreadyExistsException("Department code already present");
        }

        // Department department = new Department(
        //     departmentDto.getId(),
        //     departmentDto.getDepartmentName(),
        //     departmentDto.getDepartmentDescription(),
        //     departmentDto.getDepartmentCode()
        // );
        Department department = modelMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        // DepartmentDto savedDepartmentDto = new DepartmentDto(
        //     savedDepartment.getId(),
        //     savedDepartment.getDepartmentName(),
        //     savedDepartment.getDepartmentDescription(),
        //     savedDepartment.getDepartmentCode()
        // );
        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {

        Department department = departmentRepository.findByDepartmentCode(code);

        if (department == null) {
            throw new ResourceNotFoundException("Department code not found : " + code);
        }
        
        // DepartmentDto departmentDto = new DepartmentDto(
        //     department.getId(),
        //     department.getDepartmentName(),
        //     department.getDepartmentDescription(),
        //     department.getDepartmentCode()
        // );
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        return departmentDto;
    }

}
