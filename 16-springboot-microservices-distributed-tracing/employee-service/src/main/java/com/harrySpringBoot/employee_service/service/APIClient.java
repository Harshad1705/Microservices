package com.harrySpringBoot.employee_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harrySpringBoot.employee_service.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

      @GetMapping("api/departments/{code}")
      DepartmentDto getDepartmentByCode(@PathVariable("code") String code);
}
