package com.ygxhj.mynetty.server.command;

import org.apache.log4j.Logger;

import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;


public abstract class BaseCmd extends Command{

	Logger log = Logger.getLogger(BaseCmd.class);
	
	public CommandResult exec(CommandRequest request) throws ProductException{
		Player player = new Player();
		String cmd = "cmd";
		try {
			player.setId(request.getPlayerId());
			cmd = request.getCmd();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("status|" + cmd + "|" + player.getId());
		
		return done(player, request.getPs());
	}

	public abstract CommandResult done(Player player, String ps[]) throws ProductException;

}
