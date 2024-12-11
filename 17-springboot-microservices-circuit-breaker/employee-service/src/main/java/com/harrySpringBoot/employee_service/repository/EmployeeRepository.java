package com.harrySpringBoot.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrySpringBoot.employee_service.entity.Employee;




public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Employee findByEmail(String email);
}
