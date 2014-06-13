package com.ygxhj.mynetty.client.handel;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.ygxhj.mynetty.client.ClientSet;
import com.ygxhj.mynetty.client.RequestResult;
import com.ygxhj.mynetty.message.CommandResult;

public class ObjectClientHandler extends SimpleChannelHandler{
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {

		CommandResult result = (CommandResult) e.getMessage();
		Object object = RequestResult.getInstance().getRequest(ctx.getChannel().getId());
		
		RequestResult.getInstance().addResult(ctx.getChannel().getId(), result);
		if (object != null) {
			synchronized (object) {
				object.notify();
			}
		}
	}
	

	
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
		Channel c = e.getChannel();
		synchronized (this) {
			notify();
		}
		this.channel = c;
		System.out.println(channel);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		super.exceptionCaught(ctx, e);
	}
	
	private Channel channel;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
