package com.harrySpringBoot.springboot_restfull_webservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    
    private Long id;

    private String firstName;
    
    private String lastName;
    
    private String email;
}
