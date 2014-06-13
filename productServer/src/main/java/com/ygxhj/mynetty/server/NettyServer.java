package com.ygxhj.mynetty.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

import com.ygxhj.mynetty.handler.DefultHandler;
import com.ygxhj.mynetty.handler.ObjectServerHandler;

public class NettyServer {

	public void init(String host,int port) {
		ServerBootstrap bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ObjectServerHandler handler = new ObjectServerHandler();
				ChannelPipeline pipleline = Channels.pipeline(); 
				pipleline.addLast("encode", new ObjectEncoder());  
                pipleline.addLast("decode", new ObjectDecoder(ClassResolvers.cacheDisabled(this
		                .getClass().getClassLoader())));  
                pipleline.addLast("handler", handler);  
				return pipleline;
			}
		});
		bootstrap.bind(new InetSocketAddress(host,port));
	}


}
