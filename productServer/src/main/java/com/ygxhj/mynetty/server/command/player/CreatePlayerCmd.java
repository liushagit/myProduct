package com.ygxhj.mynetty.server.command.player;

import java.util.Date;

import org.apache.log4j.Logger;

import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.dbutil.DBService;
import com.ygxhj.mynetty.dbutil.GlobalGenerator;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.server.command.BaseCmd;

public class CreatePlayerCmd extends BaseCmd{

	@Override
	public CommandResult exec(CommandRequest request) throws ProductException {
		String name = request.getPs()[0];
		Player player = new Player();
		Date date = new Date();
		player.setId(GlobalGenerator.getInstance().getReusedIdForNewObj(Player.TABLE_NAME));
		player.setCreateTime(date);
		player.setLoginTime(date);
		player.setName(name);
		DBService.commitNoCacheUpdate(player);
		log.info(player.getId() + "|" + player.getName() + "|" + player.getCreateTime() + "|" + player.getLoginTime());
		CommandResult result = new CommandResult();
		return result;
	}
	private Logger log = Logger.getLogger(CreatePlayerCmd.class);
	@Override
	public CommandResult done(Player player, String ps[]) {
		log.info("CreatePlayerCmd|" + player.getId());
		return null;
	}

}
