package com.ygxhj.mynetty.client;

import java.util.HashMap;
import java.util.Map;

import com.ygxhj.mynetty.message.CommandResult;

public class RequestResult {

	private static final RequestResult instance = new RequestResult();
	
	
	public static RequestResult getInstance() {
		return instance;
	}

	private Map<Integer, Object> requestMap = new HashMap<Integer, Object>();
	
	public void addRequest(int id,Object object){
		requestMap.put(id, object);
	}
	public void removeRequest(int id){
		requestMap.remove(id);
	}
	
	public Object getRequest(int id){
		return requestMap.get(id);
	}
	
	private Map<Integer, CommandResult> resultMap = new HashMap<Integer, CommandResult>();
	public void addResult(int id,CommandResult result){
		resultMap.put(id, result);
	}
	public CommandResult getAndRemoveResult(int id){
		CommandResult result = resultMap.get(id);
		resultMap.remove(id);
		return result;
	}
	
}
