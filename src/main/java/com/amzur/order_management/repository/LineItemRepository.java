package com.amzur.order_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amzur.order_management.entities.LineItemEntity;

@Repository
public interface LineItemRepository extends JpaRepository<LineItemEntity, Long>{

	public List<LineItemEntity> findByOrderId(Long orderId);
	
}
