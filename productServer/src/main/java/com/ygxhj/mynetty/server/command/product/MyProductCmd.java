package com.ygxhj.mynetty.server.command.product;

import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.server.command.BaseCmd;
import com.ygxhj.mynetty.service.ProductService;

public class MyProductCmd extends BaseCmd{

	@Override
	public CommandResult done(Player player, String[] ps)
			throws ProductException {
		CommandResult result = new CommandResult();
		result.setVo("label_products", ProductService.getProductByPlayer(player));
		return result;
	}

}
