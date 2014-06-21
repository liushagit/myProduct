package com.ygxhj.mynetty.server.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ygxhj.mynetty.core.Constants;
import com.ygxhj.mynetty.core.PlayerSet;
import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;


public abstract class BaseCmd extends Command{

	Logger log = Logger.getLogger(BaseCmd.class);
	
	public CommandResult exec(CommandRequest request) throws ProductException{
		String cmd = request.getCmd();
		Player player = null;
		if("u_L".equals(cmd)){
			player = PlayerSet.getInstance().getPlayer(request.getPlayerId());
		}else{
			player = PlayerSet.getInstance().getCachPlayer(request.getPlayerId());
		}
		if (player == null) {
			CommandResult result = new CommandResult("statu_no_player");
			return result;
		}
		player.setLastMessage(System.currentTimeMillis());
		
		return done(player, request.getPs());
	}

	public abstract CommandResult done(Player player, String ps[]) throws ProductException;

	protected CommandResult callOtherCmd(Map<String, String> data) throws ProductException {
		String cmdName = data.get(PARAM_COMMAND_NAME);
		String pid = data.get(PARAM_PLAYER_ID);
		String param = data.get(PARAM);
		CommandRequest cmdReq = new CommandRequest();
		cmdReq.setCmd(cmdName);
		cmdReq.setPlayerId(Long.parseLong(pid));
		String[] psTmp = null;
		if (param != null) {
			psTmp = param.split("/");
		}
		cmdReq.setPs(psTmp);
		CommandResult result = CommandSet.getInstance().getCmd(cmdName).exec(cmdReq);
		if (result.getCmd() == null) {
			result.setCmd(Constants.CMD_RESULT);
		}
		return result;
	}

	protected CommandResult callOtherCmd(final int pid, final String cmd, final String ps) throws ProductException {
		Map<String, String> data = new HashMap<String, String>();
		data.put(PARAM_COMMAND_NAME, cmd);
		data.put(PARAM_PLAYER_ID, String.valueOf(pid));
		if(ps != null && ps.length() > 0){
			data.put(PARAM, ps);
		}
		return callOtherCmd(data);
	}
}
