package com.ygxhj.mynetty.server.command.player;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ygxhj.mynetty.core.dao.PlayerDAO;
import com.ygxhj.mynetty.core.dao.PlayerDAOImpl;
import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.core.model.PlayerExample;
import com.ygxhj.mynetty.dbutil.DBManager;
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
		String passwordAgin = request.getPs()[2];
		int group = Integer.parseInt(request.getPs()[3]);
		checkPlayerMessage(name, password,passwordAgin);
		checkName(name);
		password = MD5.encode(password,"");
		Player player = new Player();
		Date date = new Date();
		player.setId(GlobalGenerator.getInstance().getReusedIdForNewObj(Player.TABLE_NAME));
		player.setCreateTime(date);
		player.setLoginTime(date);
		player.setName(name);
		player.setPassword(password);
		player.setGroupId(group);
		DBService.commitNoCacheUpdate(player);
		log.info(player.getId() + "|" + player.getName() + "|" + player.getCreateTime() + "|" + player.getLoginTime());
		Map<String, String> data = new HashMap<String, String>();
		data.put(PARAM_COMMAND_NAME, "u_L");
		data.put(PARAM_PLAYER_ID, String.valueOf(player.getId()));
		data.put(PARAM, player.getName()+"/"+passwordAgin);
		CommandResult result = callOtherCmd(data);
		result.setCmd("u_L");
		return result;
	}
	
	private void checkName(String name) throws ProductException{
		PlayerExample example = new PlayerExample();
		example.createCriteria().andNameEqualTo(name);
		PlayerDAO dao = (PlayerDAO) DBManager.getDao(PlayerDAOImpl.class);
		try {
			List<Player> list = dao.selectByExample(example);
			if( list != null && list.size() > 0){
				throw new ProductException(name + " exists!");
			}
			
		} catch (SQLException e) {
			throw new ProductException("db error");
		}
	}
	
	private void checkPlayerMessage(String name,String password,String passwordAgin) throws ProductException{
		if(name == null || password == null
				|| name.length() <= 0 || password.length() <= 0){
			throw new ProductException("name " + name + " password " + password + " error!");
		}
		if (!password.equals(passwordAgin)) {
			throw new ProductException("password is not same!");
		}
	}
	
	private Logger log = Logger.getLogger(CreatePlayerCmd.class);
	@Override
	public CommandResult done(Player player, String ps[]) {
		log.info("CreatePlayerCmd|" + player.getId());
		return null;
	}

}
