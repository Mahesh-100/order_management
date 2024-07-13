package com.amzur.order_management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amzur.order_management.entities.OrderEntity;





@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	
	
	public List<OrderEntity> findByUserId(Long userId);
	public List<OrderEntity>findAllByOrderDate(LocalDate orderDate);
}
