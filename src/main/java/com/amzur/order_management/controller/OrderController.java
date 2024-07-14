package com.amzur.order_management.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amzur.order_management.dto.request.OrderRequest;
import com.amzur.order_management.dto.response.OrderResponse;
import com.amzur.order_management.service.OrderService;
@RestController
@RequestMapping("/orders")
public class OrderController {
	 @Autowired
	    private OrderService orderService;

	    // Create an order: POST http://localhost:8080/orders
	    @PostMapping
	    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
	    	//System.out.println("Book IDs:"+ orderRequest.getBookIds());
	        return orderService.createOrder(orderRequest);
	    }
	    
	    
	    @GetMapping("/{orderId}")
	    public List<OrderResponse> getOrderById(@PathVariable Long orderId) {
	    	
	        return orderService.getOrderById(orderId);
	    }
	    @GetMapping("/userId/{userId}")
	    public List<OrderResponse> getAllOrdersByUserId(@PathVariable Long userId) {
	    	return orderService.getAllOrdersByUserId(userId);
	    }
	    @GetMapping("/count/{date}")
	    public Long getUserWithMaxOrders(@PathVariable LocalDate date) {
	    	return orderService.getUserWithMaxOrders(date);
	    }
}
