package com.ygxhj.mynetty.servlet;

import javax.servlet.http.HttpServletRequest;

import com.ygxhj.mynetty.exception.SignException;
import com.ygxhj.mynetty.message.CommandRequest;

public class Proxy2Servlet extends ProxyServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected CommandRequest pareReq(HttpServletRequest request) throws SignException{
		//cmd=""&pid=""&time=""&md5=""&1=""&2="".......
		return null;
	}
	
	

}
