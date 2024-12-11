package com.harrySpringBoot.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harrySpringBoot.department_service.dto.DepartmentDto;
import com.harrySpringBoot.department_service.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(
    name = "Department Service - DepartmentController",
    description = "Department Controller Exposes REST APIs for Department-Service" 
)
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Operation(
        summary = "Save Department REST API",
        description = "Save Department REST API is used to save department object in database"
        
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        DepartmentDto savDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savDepartmentDto, HttpStatus.CREATED);
    }


    @Operation(
        summary = "Get Department REST API",
        description = "Get Department REST API is used to get department object from database"
        
    )
    @ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
