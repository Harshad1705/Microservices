package com.harrySpringBoot.springboot_restfull_webservices.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harrySpringBoot.springboot_restfull_webservices.dto.UserDto;
import com.harrySpringBoot.springboot_restfull_webservices.entity.User;
import com.harrySpringBoot.springboot_restfull_webservices.mapper.AutoUserMapper;
import com.harrySpringBoot.springboot_restfull_webservices.repository.UserRepository;
import com.harrySpringBoot.springboot_restfull_webservices.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    // private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // convert user dto into user jpa entity
        // User user = UserMapper.mapToUserJpa(userDto);
        // User user = modelMapper.map(userDto,User.class);
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        
        User savedUser = userRepository.save(user);

        // convert user jpa entity to user dto
        // UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        // UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        // return UserMapper.mapToUserDto(user);
        // return modelMapper.map(user,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
        
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        // return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        // return users.stream().map((user)->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return users.stream().map((user)->AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        // User existingUser = UserMapper.mapToUserJpa(getUserById(user.getId()));
        // User existingUser = modelMapper.map(getUserById(user.getId()),User.class);
        User existingUser = AutoUserMapper.MAPPER.mapToUser(getUserById(user.getId()));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
        
        // return UserMapper.mapToUserDto(updatedUser);
        // return modelMapper.map(updatedUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
}