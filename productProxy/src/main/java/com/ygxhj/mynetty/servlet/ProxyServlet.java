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
import com.ygxhj.mynetty.config.GlobalConfig;
import com.ygxhj.mynetty.config.Zone;
import com.ygxhj.mynetty.exception.SignException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.util.MD5;
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
		
		if (req.getCmd().equals(ProxyHelper.REGISTER_CMD)) {
			CommandResult result1 = new CommandResult();
			result1.setCmd(ProxyHelper.REGISTER_CMD);
			template(result1, out);
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
		
		if("statu_no_player".equals(result.getStatus())){
			Zone zone = GlobalConfig.getZone(GlobalConfig.zoneId);
			String url = "http://" + zone.getProxyHost()+ ":" + zone.getProxyPort()+"/login.jsp";
			log("url==" + url);
			response.sendRedirect(url);
			return;
		}
		addSign(req, result);
		template(result, out);
		
	}
	
	private void template(CommandResult result,PrintWriter out){
		try {
			Template t = ProxyHelper.getTemplate(result);
			try {
				t.process(result.getData(), out);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
		}
	}
	
	protected CommandRequest pareReq(HttpServletRequest request) throws SignException,ServletException{
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
		if (ProxyHelper.REGISTER_CMD.equals(cmd)) {
			req.setCmd(cmd);
			return req; 
		}
		String ms[] = qs[1].split(ProxyHelper.UNDER_LINE);
		long pid = Long.parseLong(ms[0]);
		String time = ms[1];
		String sign = ms[2].split("-")[0];
		String signAll = ms[2].split("-")[1];
		String ps[] = null;
		if (qs.length > 2) {
			ps = new String[qs.length - 2];
			for (int i = 2; i < qs.length; i++) {
				ps[i - 2] = qs[i];
			}
		}
		StringBuffer md5Word = new StringBuffer();
		StringBuffer md5All = new StringBuffer();
		md5Word.append(pid);
		md5Word.append(time);
		md5All.append(cmd);
		md5All.append(pid).append(ProxyHelper.UNDER_LINE);
		md5All.append(time).append(ProxyHelper.UNDER_LINE);
		md5All.append(sign);
		if (ps != null) {
			for (int i = 0; i < ps.length; i++) {
				md5All.append(ps[i]).append("/");
			}
		}
		Zone zone = GlobalConfig.getZone(GlobalConfig.zoneId);
//		if (!cmd.equals("p_CP")) {
			checkMd5(md5Word.toString(), sign,zone.getMd5Key());
			checkMd5(md5All.toString(), signAll,zone.getMd5Key());
//		}
		
		req.setPlayerId(pid);
		req.setCmd(cmd);
		req.setPs(ps);
		return req;
		
	}
	
	protected void checkMd5(String md5Word,String sign,String key) throws SignException{
		String si = MD5.encode(md5Word, key);
		if (!si.equals(sign)) {
			throw new SignException("书签校验错误！");
//			log("sign error", new SignException("书签校验错误！"));
		}
	}
	
	protected void addSign(CommandRequest reqCmd, CommandResult result){
		String time = Integer.toHexString((int) (System.currentTimeMillis() / 1000));
		StringBuffer sb = new StringBuffer();
		long pid = reqCmd.getPlayerId();
		if(reqCmd.getPlayerId() <= 0){
			sb.append(result.getVo("label_player_id"));
			pid = Long.parseLong(result.getVo("label_player_id").toString());
		}else{
			sb.append(reqCmd.getPlayerId());
		}
		sb.append(ProxyHelper.UNDER_LINE).append(time);
		Zone zone = GlobalConfig.getZone(GlobalConfig.zoneId);
		String si = MD5.encode(pid + time, zone.getMd5Key());
		sb.append(ProxyHelper.UNDER_LINE).append(si);
		result.setVo("sign", sb.toString());
	}

}
