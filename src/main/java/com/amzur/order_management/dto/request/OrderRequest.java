package com.amzur.order_management.dto.request;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;

public class OrderRequest {
	 @NotNull
	    private Long userId;
	    @NotNull
	    private List<Integer> bookIds;
	    private LocalDate orderDate;
	    
	    public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public List<Integer> getBookIds() {
			return bookIds;
		}
		public void setBookIds(List<Integer> bookIds) {
			this.bookIds = bookIds;
		}
		public LocalDate getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
	    
	    
}
