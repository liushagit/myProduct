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
import com.ygxhj.mynetty.util.MD5;

public class CreatePlayerCmd extends BaseCmd{

	@Override
	public CommandResult exec(CommandRequest request) throws ProductException {
		String name = request.getPs()[0];
		String password = request.getPs()[1];
		int group = Integer.parseInt(request.getPs()[2]);
		checkPlayerMessage(name, password);
		password = MD5.encode(password);
		Player player = new Player();
		Date date = new Date();
		player.setId(GlobalGenerator.getInstance().getReusedIdForNewObj(Player.TABLE_NAME));
		player.setCreateTime(date);
		player.setLoginTime(date);
		player.setName(name);
		player.setPassword(password);
		player.setGroup(group);
		DBService.commitNoCacheUpdate(player);
		log.info(player.getId() + "|" + player.getName() + "|" + player.getCreateTime() + "|" + player.getLoginTime());
		CommandResult result = new CommandResult();
		return result;
	}
	
	private void checkPlayerMessage(String name,String password) throws ProductException{
		if(name == null || password == null
				|| name.length() <= 0 || password.length() <= 0){
			throw new ProductException("name " + name + " password " + password + " error!");
		}
	}
	
	private Logger log = Logger.getLogger(CreatePlayerCmd.class);
	@Override
	public CommandResult done(Player player, String ps[]) {
		log.info("CreatePlayerCmd|" + player.getId());
		return null;
	}

}
