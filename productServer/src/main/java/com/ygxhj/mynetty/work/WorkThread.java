package com.ygxhj.mynetty.work;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibatis.common.beans.ProbeException;
import com.ygxhj.mynetty.core.Constants;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.message.OutputMessage;
import com.ygxhj.mynetty.server.command.Command;
import com.ygxhj.mynetty.server.command.CommandSet;
import com.ygxhj.mynetty.work.RequestPool.NotifyItem;



public class WorkThread extends Thread{
	private Logger log = Logger.getLogger(WorkThread.class);
	private int warnSize = 100;
	private int timeOut = 2000;
	@Override
	public void run() {
		LinkedBlockingQueue<NotifyItem> requestQueue = null;
		NotifyItem notify = null;
		while (true) {
			try {
				requestQueue = RequestPool.inst.getRequestQueue();
				notify = requestQueue.poll(100, TimeUnit.MICROSECONDS);
				while(notify != null) {
					if (System.currentTimeMillis() - notify.getRequestTime() < timeOut) {
						exec(notify);
					}else {
						CommandRequest request = notify.getRequest();
						log.error("timeout:" + request.getPlayerId() + "|" + request.getCmd());
					}
					int size = requestQueue.size();
					if (size > warnSize) {
						log.warn("requestQueue size is:" + size + "..........");
					}
					notify = requestQueue.poll(100, TimeUnit.MICROSECONDS);
				}
				
			} catch (Exception e) {
				log.error("workThread exception", e);
			}
		}
	}
	
	private void exec(NotifyItem notify){
		try {
			String c = notify.getRequest().getCmd();
			Command cmd = CommandSet.getInstance().getCmd(c);
			if (cmd == null) {
				log.error("cmd is null :" + c + "....");
				return;
			}
			long begin = System.currentTimeMillis();
			CommandResult result = cmd.exec(notify.getRequest());
			if (result.getCmd().equals(Constants.CMD_RESULT)) {
				result.setCmd(c);
			}
			log.info("status|"+c+"|" + result.getCmd() + "|" + result.getStatus() + "|" + (System.currentTimeMillis() - begin));
			resp(notify, result);
		} catch (ProductException e) {
			log.error("exec exception", e);
			CommandResult result = new CommandResult(Constants.CMD_STATUS_FAIL);
			result.setVo(Constants.LABEL_DESC, e.getMsg());
			resp(notify, result);
		}
	}
	
	private void resp(NotifyItem notify, CommandResult result){
		Channel channel = notify.getChannel();
		channel.write(result);
		log.info("resp|" + channel + "|" + result.toString());
	}

}
