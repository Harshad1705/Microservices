package com.harrySpringBoot.springboot_restfull_webservices.service;

import java.util.List;

import com.harrySpringBoot.springboot_restfull_webservices.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);


} 
