package com.ygxhj.mynetty.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.ygxhj.mynetty.config.GlobalConfig;
import com.ygxhj.mynetty.config.Zone;
import com.ygxhj.mynetty.exception.SignException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.util.ProxyHelper;

public class Proxy2Servlet extends ProxyServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected CommandRequest pareReq(HttpServletRequest request) throws SignException,ServletException{
		CommandRequest cmdReq = new CommandRequest();
		
		String cmd = request.getParameter("cmd");
		String sign = request.getParameter("sign");
		int psLen = request.getParameterMap().size();
		List<String> ps = new ArrayList<String>();
		for (int i = 1; i <= psLen; i++) {
			String p = request.getParameter(String.valueOf(i));
			if (p == null) {
				break;
			}
			ps.add(p);
		}
		
		if(!"u_L".equals(cmd)){
			String ss[] = sign.split(ProxyHelper.UNDER_LINE);
			String md5Word = ss[0] + ss[1];
			Zone zone = GlobalConfig.getZone(GlobalConfig.zoneId);
			checkMd5(md5Word, ss[2], zone.getMd5Key());
			cmdReq.setPlayerId(Long.parseLong(ss[0]));
		}
		
		cmdReq.setCmd(cmd);
		cmdReq.setPs(ps.toArray(new String[]{}));
		log(cmdReq.toString());
		return cmdReq;
	}

}
