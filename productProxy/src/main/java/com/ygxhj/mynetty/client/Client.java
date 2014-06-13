package com.ygxhj.mynetty.client;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;
import org.json.JSONObject;

import com.ygxhj.mynetty.client.handel.DefultHandel;
import com.ygxhj.mynetty.client.handel.ObjectClientHandler;
import com.ygxhj.mynetty.config.GlobalConfig;
import com.ygxhj.mynetty.core.Constants;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.InputMessage;
import com.ygxhj.mynetty.message.OutputMessage;
import com.ygxhj.mynetty.util.MD5;

public class Client {

	private String serverIp;
	private int serverPort;

	public Client(String serverIp, int serverPort) {
		this.serverIp = serverIp;
		this.serverPort = serverPort;
		connect();
	}

	private ObjectClientHandler handler = new ObjectClientHandler();

	private void connect() {
		if (handler.getChannel() != null && handler.getChannel().isWritable()) {
			return;
		}
		ClientBootstrap bootstrap = new ClientBootstrap(
				new NioClientSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipleline = Channels.pipeline(); 
				pipleline.addLast("encode", new ObjectEncoder());  
                pipleline.addLast("decode", new ObjectDecoder(ClassResolvers.cacheDisabled(this
		                .getClass().getClassLoader())));  
                pipleline.addLast("handler", handler);  
				return pipleline;
			}
		});

		bootstrap.connect(new InetSocketAddress(serverIp, serverPort));
	}

	
	public void sendObject(CommandRequest request) {
		handler.getChannel().write(request);
    }
	
	public boolean isWritable(){
		
		return handler.getChannel().isWritable();
	}
	
	public Channel getChannel(){
		return handler.getChannel();
	}
}
