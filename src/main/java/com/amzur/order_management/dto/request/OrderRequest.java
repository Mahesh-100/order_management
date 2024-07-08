package com.amzur.order_management.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class OrderRequest {
	 @NotNull
	    private Long userId;
	    @NotNull
	    private List<Integer> bookIds;
		
	    
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
	    
	    
}
