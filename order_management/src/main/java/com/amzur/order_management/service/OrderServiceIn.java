package com.amzur.order_management.service;

import java.util.List;

import com.amzur.order_management.dto.request.OrderRequest;
import com.amzur.order_management.dto.response.OrderResponse;

public interface OrderServiceIn {
	
	public OrderResponse save(OrderRequest orderRequest);
    public List<OrderResponse> findAll();
   public  OrderResponse findByOrderId(Long orderId);
    public void deleteByOrderId(Long orderId);

}
