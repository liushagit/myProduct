package com.ygxhj.mynetty.server.command.player;

import java.util.List;

import com.ygxhj.mynetty.core.PlayerSet;
import com.ygxhj.mynetty.core.dao.PlayerDAO;
import com.ygxhj.mynetty.core.dao.PlayerDAOImpl;
import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.core.model.PlayerExample;
import com.ygxhj.mynetty.dbutil.DBManager;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.server.command.Command;
import com.ygxhj.mynetty.util.MD5;

public class LoginCmd extends Command{

	@Override
	public CommandResult exec(CommandRequest request) throws ProductException {
		CommandResult result = new CommandResult();
		String ps[] = request.getPs();
		PlayerExample example = new PlayerExample();
		example.createCriteria().andNameEqualTo(ps[0]);
		PlayerDAO dao = (PlayerDAO) DBManager.getDao(PlayerDAOImpl.class);
		Player p = null;
		try {
			List<Player> list = dao.selectByExample(example);
			if(list == null || list.size() <= 0){
				throw new ProductException("用户：" + ps[0] + "不存在！");
			}
			p = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String password = MD5.encode(ps[1], "");
		
		String pp = p.getPassword();
		if (!password.equals(pp)) {
			throw new ProductException("密码错误，请重新登录");
		}
		PlayerSet.getInstance().getPlayer(p.getId());
		result.setVo("label_player_id", p.getId());
		return result;
	}

	@Override
	public CommandResult done(Player player, String[] ps)
			throws ProductException {
		return null;
	}

}
