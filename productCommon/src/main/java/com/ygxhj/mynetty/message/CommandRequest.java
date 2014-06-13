package com.ygxhj.mynetty.message;

import java.io.Serializable;

public class CommandRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cmd;
	private int playerId;
	private String[] ps;

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String[] getPs() {
		return ps;
	}

	public void setPs(String[] ps) {
		this.ps = ps;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(playerId).append(",").append(cmd).append(",");
		for (int i = 0; i < ps.length; i++) {
			sb.append(ps[i]).append(",");
		}
		return sb.toString();
	}

	
}
