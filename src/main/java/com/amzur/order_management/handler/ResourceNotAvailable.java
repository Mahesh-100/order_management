package com.amzur.order_management.handler;

public class ResourceNotAvailable extends RuntimeException{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotAvailable (String message) {
		super(message);
	}
	
}
