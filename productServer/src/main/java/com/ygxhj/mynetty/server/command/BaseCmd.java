package com.ygxhj.mynetty.server.command;

import org.apache.log4j.Logger;

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
		if(!"u_L".equals(cmd)){
			player = PlayerSet.getInstance().getPlayer(request.getPlayerId());
		}else{
			player = PlayerSet.getInstance().getCachPlayer(request.getPlayerId());
		}
		if (player == null) {
			CommandResult result = new CommandResult("statu_no_player");
			return result;
		}
		log.info("status|" + cmd + "|" + player.getId());
		
		return done(player, request.getPs());
	}

	public abstract CommandResult done(Player player, String ps[]) throws ProductException;

}
