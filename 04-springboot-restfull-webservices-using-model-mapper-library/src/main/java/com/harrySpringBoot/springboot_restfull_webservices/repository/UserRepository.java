package com.harrySpringBoot.springboot_restfull_webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrySpringBoot.springboot_restfull_webservices.entity.User;


public interface UserRepository extends JpaRepository<User,Long>{

}
