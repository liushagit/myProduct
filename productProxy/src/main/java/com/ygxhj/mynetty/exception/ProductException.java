package com.ygxhj.mynetty.exception;

public class ProductException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public ProductException(String msg){
		super(msg);
		this.msg = msg;
	}
	
}
