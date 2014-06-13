package com.ygxhj.mynetty.test.product;

import com.ygxhj.mynetty.client.Client;
import com.ygxhj.mynetty.client.ClientSet;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.server.ClientServer;

import junit.framework.TestCase;

public class UserTest extends TestCase{

	private void init(){
		ClientServer clientServer = new ClientServer();
		clientServer.initClient();
	}
	
	 public void testCreateProduct() {
		init();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long begin = System.currentTimeMillis();
		Client client = ClientSet.getInstance().getClient();
		
		CommandRequest request = new CommandRequest();
		request.setCmd("u_CP");
		String ps[] = new String[7];
		ps[0] = "测试1";
		ps[1] = "123456";
		ps[2] = "1";
		
		request.setPs(ps);
		client.sendObject(request);
		ClientSet.getInstance().backClient(client);
		System.out.println("end|" + (System.currentTimeMillis() - begin));
	 }
	 
}
