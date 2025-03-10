package com.harrySpringBoot.springboot_restfull_webservices.service;

import java.util.List;

import com.harrySpringBoot.springboot_restfull_webservices.entity.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);


} 
