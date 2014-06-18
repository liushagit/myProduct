package com.ygxhj.mynetty.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.ygxhj.mynetty.exception.SignException;
import com.ygxhj.mynetty.message.CommandRequest;

public class Proxy2Servlet extends ProxyServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected CommandRequest pareReq(HttpServletRequest request) throws SignException,ServletException{
		CommandRequest cmdReq = new CommandRequest();
		
		String cmd = request.getParameter("cmd");
		int psLen = request.getParameterMap().size();
		List<String> ps = new ArrayList<String>();
		for (int i = 1; i <= psLen; i++) {
			String p = request.getParameter(String.valueOf(i));
			if (p == null) {
				break;
			}
			ps.add(p);
		}
		cmdReq.setCmd(cmd);
		cmdReq.setPs(ps.toArray(new String[]{}));
		log(cmdReq.toString());
		return cmdReq;
	}
	
	

}
