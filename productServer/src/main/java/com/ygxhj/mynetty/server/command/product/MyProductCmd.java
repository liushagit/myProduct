package com.ygxhj.mynetty.server.command.product;

import java.util.List;

import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.core.model.Product;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.server.command.BaseCmd;
import com.ygxhj.mynetty.service.ProductService;

public class MyProductCmd extends BaseCmd{

	@Override
	public CommandResult done(Player player, String[] ps)
			throws ProductException {
		CommandResult result = new CommandResult();
		List<Product> list = ProductService.getProductByPlayer(player);
		if (list != null && list.size() > 0) {
			result.setVo("label_products", list);
		}
		result.setVo("label_center", 1);
		return result;
	}

}
