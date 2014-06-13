package com.ygxhj.mynetty.test.product;

import com.ygxhj.mynetty.client.Client;
import com.ygxhj.mynetty.client.ClientSet;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.server.ClientServer;

import junit.framework.TestCase;

public class ProductTest extends TestCase{

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
		request.setCmd("p_CP");
		String ps[] = new String[7];
		ps[0] = "123456";
		ps[1] = "测试产品";
		ps[2] = "测试产品说明";
		ps[3] = "1";
		ps[4] = "100";
		ps[5] = "10";
		ps[6] = "3";
		request.setPs(ps);
		client.sendObject(request);
		ClientSet.getInstance().backClient(client);
		System.out.println("end|" + (System.currentTimeMillis() - begin));
	 }
	 
	 public void testConsumProduct() {
			init();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long begin = System.currentTimeMillis();
			Client client = ClientSet.getInstance().getClient();
			
			CommandRequest request = new CommandRequest();
			request.setCmd("p_CSP");
			String ps[] = new String[2];
			ps[0] = "123456";
			ps[1] = "3";
			request.setPs(ps);
			client.sendObject(request);
			ClientSet.getInstance().backClient(client);
			System.out.println("end|" + (System.currentTimeMillis() - begin));
		 }
	 
	 
	 public void testEquql(){
		 String string = "a";
		 Test t = new Test();
		 Test t1 = new Test();
		 inst(t);
		 System.out.println(string.equals(t));
		 System.out.println(t.equals(t1));
	 }
	 
	 public void inst(Object object){
		 System.out.println(object);
		 if (object instanceof String) {
			System.out.println(true);
		}else {
			System.out.println(false );
			
		}
	 }
}
