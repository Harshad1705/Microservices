package com.harrySpringBoot.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrySpringBoot.department_service.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Long>{

       Department findByDepartmentCode(String code);
} 
