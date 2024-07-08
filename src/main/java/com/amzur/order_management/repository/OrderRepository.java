package com.amzur.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amzur.order_management.entities.OrderEntity;





@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
