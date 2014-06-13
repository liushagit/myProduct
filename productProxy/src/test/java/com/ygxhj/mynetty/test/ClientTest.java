package com.ygxhj.mynetty.test;

import java.util.Random;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.ygxhj.mynetty.client.Client;
import com.ygxhj.mynetty.client.ClientSet;
import com.ygxhj.mynetty.core.Constants;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.server.ClientServer;

public class ClientTest {

	public static void main(String[] args) {
		ClientServer clientServer = new ClientServer();
		clientServer.initClient();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			Client client2 = ClientSet.getInstance().getClient();
			if (!client2.isWritable()) {
				continue;
			}
			JSONObject json = new JSONObject();
			try {
				json.put(Constants.CMD, "u_CP");
				json.put("name", "name_" + new Random().nextInt(100000));
			} catch (JSONException e) {
				e.printStackTrace();
			}
//			client2.sendMessage(json);
			CommandRequest request = new CommandRequest();
			request.setCmd("p_CP");
			String ps[] = new String[4];
			ps[0] = "123456";
			ps[1] = "测试产品";
			ps[2] = "测试产品说明";
			ps[3] = "3";
			request.setPs(ps);
			client2.sendObject(request);
			ClientSet.getInstance().backClient(client2);
		}
		System.out.println(System.currentTimeMillis() - begin);
	}
}
