package com.amzur.order_management.handler;

public class UserAlreadyExist extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExist(String msg) {
		super(msg);
	}

}
