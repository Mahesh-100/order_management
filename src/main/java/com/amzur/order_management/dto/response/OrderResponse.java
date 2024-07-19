package com.amzur.order_management.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class OrderResponse {

	private Long orderId;
	private Long userId;
	private LocalDate orderDate;
	private List<LineItemResponse> lineItems;
	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<LineItemResponse> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemResponse> lineItems) {
		this.lineItems = lineItems;
	}
	
	

	
	
	
	
}
