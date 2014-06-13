package com.ygxhj.mynetty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ygxhj.mynetty.client.Client;
import com.ygxhj.mynetty.client.ClientSet;
import com.ygxhj.mynetty.client.RequestResult;
import com.ygxhj.mynetty.exception.SignException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.util.ProxyHelper;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class ProxyServlet
 */
public class ProxyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProxyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		CommandRequest req = null;
		try {
			req = pareReq(request);
		} catch (SignException e) {
			log(e.getMessage() ,e);
			//TODO 转向
			response.sendRedirect("error.jsp");
			return;
		}
		
		Client client = ClientSet.getInstance().getClient();
		client.sendObject(req);
		ClientSet.getInstance().backClient(client);
		RequestResult.getInstance().addRequest(client.getChannel().getId(), client.getChannel());
		try {
			synchronized (client.getChannel()) {
				client.getChannel().wait(3000);
			}
		} catch (InterruptedException e) {
			RequestResult.getInstance().removeRequest(client.getChannel().getId());
			//TODO 转向
			return;
		}
		
		CommandResult result = RequestResult.getInstance().getAndRemoveResult(client.getChannel().getId());
		if (result == null) {
			//TODO 转向
			return;
		}
		log(result.toString());
		Template t = ProxyHelper.getTemplate(result);
		try {
			t.process(result.getVo(), out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	protected CommandRequest pareReq(HttpServletRequest request) throws SignException{
		CommandRequest req = new CommandRequest();
		String query = request.getQueryString();
		try {
			query = URLDecoder.decode(query,"utf-8");
		} catch (Exception e) {
		}
		//query格式
		//cmd/pid_time_md5/ps....
		String qs[] = query.split("/");
		String cmd = qs[0];
		String ms[] = qs[1].split("_");
		int pid = Integer.parseInt(ms[0]);
		String time = ms[1];
		String ps[] = null;
		if (qs.length > 2) {
			ps = new String[qs.length - 2];
			for (int i = 2; i < qs.length; i++) {
				ps[i - 2] = qs[i];
			}
		}else {
			ps = new String[1];
			ps[0] = "";
		}
		StringBuffer md5Word = new StringBuffer();
		md5Word.append(pid);
		md5Word.append(time);
		for (int i = 0; i < ps.length; i++) {
			md5Word.append(ps[i]);
		}
		checkMd5(md5Word.toString(), ms[2]);
		req.setPlayerId(pid);
		req.setCmd(cmd);
		req.setPs(ps);
		return req;
		
	}
	
	private void checkMd5(String md5Word,String sign) throws SignException{
		
	}

}
