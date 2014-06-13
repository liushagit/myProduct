package com.ygxhj.mynetty.work;

import java.util.concurrent.LinkedBlockingQueue;

import org.jboss.netty.channel.Channel;
import org.json.JSONObject;

import com.ygxhj.mynetty.message.CommandRequest;

public class RequestPool {

	public static final RequestPool inst = new RequestPool();
	public LinkedBlockingQueue<NotifyItem> requestQueue = new LinkedBlockingQueue<NotifyItem>();

	private RequestPool(){}

	public class NotifyItem {

		private long requestTime;
		private CommandRequest request;
		public CommandRequest getRequest() {
			return request;
		}
		public void setRequest(CommandRequest request) {
			this.request = request;
		}
		private Channel channel;
		public long getRequestTime() {
			return requestTime;
		}
		public void setRequestTime(long requestTime) {
			this.requestTime = requestTime;
		}
		public Channel getChannel() {
			return channel;
		}
		public void setChannel(Channel channel) {
			this.channel = channel;
		}
		
	}

	/**
	 * 添加个请求到队列
	 * 
	 * @param session
	 *            请求对应的Session
	 * @param request
	 *            请求数据
	 * @param recvTime
	 *            接收时间
	 */
	public void addRequest(CommandRequest request,Channel channel) {
		NotifyItem ni = new NotifyItem();
		ni.setRequestTime(System.currentTimeMillis());
		ni.setRequest(request);
		ni.setChannel(channel);
		requestQueue.add(ni);
	}

	public LinkedBlockingQueue<NotifyItem> getRequestQueue() {
		return requestQueue;
	}
}
