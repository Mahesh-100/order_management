package com.amzur.order_management.dto.response;

import lombok.Data;

@Data
public class OrderResponse {

	private Long orderId;

	private int bookId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	
	
	
	
}
