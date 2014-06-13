package com.ygxhj.mynetty.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ygxhj.mynetty.server.ClientServer;
import com.ygxhj.mynetty.util.ProxyHelper;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void init() throws ServletException {
    	ClientServer clientServer = new ClientServer();
		clientServer.initClient();
		
		ProxyHelper.REGEX_FILE = getServletContext().getInitParameter("regexFile");
		ProxyHelper.TEMPLATE_DIR = getServletContext().getInitParameter("templateDir");
		ProxyHelper.MSG_CHARSET = getServletContext().getInitParameter("charSet");
		
		String path = getServletContext().getRealPath("/");
		
		//初始化模板文件
		String regexFile = path + "WEB-INF/" + ProxyHelper.REGEX_FILE;
		ProxyHelper.initFreeMarker(getServletContext(), regexFile);
		
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
