package com.harrySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrySpringBoot.entity.StockOrder;

public interface OrderRepository extends JpaRepository<StockOrder,Long>{

    
} 
