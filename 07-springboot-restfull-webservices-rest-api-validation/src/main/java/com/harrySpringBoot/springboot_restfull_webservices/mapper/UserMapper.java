package com.harrySpringBoot.springboot_restfull_webservices.mapper;

import com.harrySpringBoot.springboot_restfull_webservices.dto.UserDto;
import com.harrySpringBoot.springboot_restfull_webservices.entity.User;

public class UserMapper {
    
    // convert user jpa entity into user dto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
            );
        return userDto;
    }
    
    // convert user dto into user jpa entity
    public static User mapToUserJpa(UserDto userDto) {
        User user = new User(
            userDto.getId(),
            userDto.getFirstName(),
            userDto.getLastName(),
            userDto.getEmail()
        );

        return user;
    
    }

}
