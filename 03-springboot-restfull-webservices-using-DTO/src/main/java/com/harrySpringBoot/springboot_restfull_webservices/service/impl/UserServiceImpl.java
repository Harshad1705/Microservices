package com.harrySpringBoot.springboot_restfull_webservices.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harrySpringBoot.springboot_restfull_webservices.dto.UserDto;
import com.harrySpringBoot.springboot_restfull_webservices.entity.User;
import com.harrySpringBoot.springboot_restfull_webservices.mapper.UserMapper;
import com.harrySpringBoot.springboot_restfull_webservices.repository.UserRepository;
import com.harrySpringBoot.springboot_restfull_webservices.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // convert user dto into user jpa entity
        User user = UserMapper.mapToUserJpa(userDto);
        
        User savedUser = userRepository.save(user);

        // convert user jpa entity to user dto
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        UserDto userDto = UserMapper.mapToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = UserMapper.mapToUserJpa(getUserById(user.getId()));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
        
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
}