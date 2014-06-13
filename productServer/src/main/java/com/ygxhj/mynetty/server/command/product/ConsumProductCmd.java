package com.ygxhj.mynetty.server.command.product;

import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.server.command.BaseCmd;
import com.ygxhj.mynetty.service.ProductService;

public class ConsumProductCmd extends BaseCmd{

	@Override
	public CommandResult done(Player player, String[] ps)
			throws ProductException {
		CommandResult result = new CommandResult();
		String productId = ps[0];
		int number = 0;
		try {
			number = Integer.parseInt(ps[1]);
			
		} catch (Exception e) {
			throw new ProductException("consum number error!");
		}
		
		ProductService.consumProduct(player, productId, number);
		return result;
	}

}
