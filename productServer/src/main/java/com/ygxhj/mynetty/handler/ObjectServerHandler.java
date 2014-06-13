package com.ygxhj.mynetty.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.json.JSONObject;

import com.ygxhj.mynetty.config.GlobalConfig;
import com.ygxhj.mynetty.core.Constants;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.util.MD5;
import com.ygxhj.mynetty.work.RequestPool;

public class ObjectServerHandler extends SimpleChannelHandler {

	private Logger log = Logger.getLogger(DefultHandler.class);

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		CommandRequest command = (CommandRequest) e.getMessage();
		RequestPool.inst.addRequest(command, ctx.getChannel());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
	}

	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
	}

	@Override
	public void closeRequested(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		log.debug("channelConnected");
	}
}
