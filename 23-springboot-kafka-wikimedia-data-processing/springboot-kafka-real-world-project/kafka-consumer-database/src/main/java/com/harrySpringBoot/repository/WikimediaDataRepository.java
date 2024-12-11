package com.harrySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrySpringBoot.entity.Wikimedia;

public interface WikimediaDataRepository extends JpaRepository<Wikimedia,Long>{

}
