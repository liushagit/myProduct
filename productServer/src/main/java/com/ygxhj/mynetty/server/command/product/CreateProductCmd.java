package com.ygxhj.mynetty.server.command.product;


import com.ygxhj.mynetty.core.Constants;
import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandResult;
import com.ygxhj.mynetty.server.command.BaseCmd;
import com.ygxhj.mynetty.service.ProductService;

public class CreateProductCmd extends BaseCmd{

	@Override
	public CommandResult done(Player player, String ps[]) throws ProductException {
		if (ps == null || ps.length < 4) {
			throw new ProductException("create product ps is error!");
		}
		CommandResult result = new CommandResult();
		String productId = ps[0];
		String name = ps[1];
		String destance = ps[2];
		int number = 0;
		int price = 0;
		int discount = 0;
		int deductPrice = 0;
		try {
			number = Integer.parseInt(ps[3]);
			price = Integer.parseInt(ps[4]);
			discount = Integer.parseInt(ps[5]);
			deductPrice = Integer.parseInt(ps[6]);
		} catch (Exception e) {
			throw new ProductException("create product number is error!");
		}
		ProductService.addProduct(player,productId, name, destance, number,price,discount,deductPrice);
		result.setVo(Constants.LABEL_DESC, "创建成功！");
		return result;
	}


}
