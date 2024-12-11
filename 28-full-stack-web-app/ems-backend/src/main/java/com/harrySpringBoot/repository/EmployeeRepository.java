package com.harrySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.harrySpringBoot.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long>{

}
