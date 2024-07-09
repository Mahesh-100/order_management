package com.amzur.order_management.service;

import java.util.List;

import com.amzur.order_management.dto.request.OrderRequest;
import com.amzur.order_management.dto.response.OrderResponse;

public interface OrderService {
	
	public OrderResponse createOrder(OrderRequest orderRequest);
   
   public  List<OrderResponse> getOrderById(Long orderId);
   
   public List<OrderResponse> getAllOrdersByUserId(Long userId);

}
