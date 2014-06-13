package com.ygxhj.mynetty.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.ygxhj.mynetty.core.Constants;

public class CommandResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommandResult(){
		this(Constants.CMD_STATUS_SUCC);
	}
	public CommandResult(String statuc){
		this.status = statuc;
		this.cmd = Constants.CMD_RESULT;
	}
	private Map<String, Object> vo = new HashMap<String, Object>();
	private String status;
	private String cmd;
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Map<String, Object> getVo() {
		return vo;
	}
	public void setVo(String label,Object object) {
		vo.put(label, object);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(status).append(",").append(cmd).append(",");
		for (String key : vo.keySet()) {
			sb.append(key).append("_").append(vo.get(key)).append(",");
		}
		return sb.toString();
	}
	
}
