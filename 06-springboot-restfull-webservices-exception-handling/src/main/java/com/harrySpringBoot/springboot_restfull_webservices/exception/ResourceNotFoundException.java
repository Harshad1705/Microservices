package com.harrySpringBoot.springboot_restfull_webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fielValue) {
        super(String.format("%s not found with %s : '%s", resourceName, fieldName, fielValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fielValue;
    }
    
}
