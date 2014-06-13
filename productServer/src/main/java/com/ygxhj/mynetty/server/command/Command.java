package com.ygxhj.mynetty.server.command;

import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;

public abstract class Command {

	public abstract CommandResult exec(CommandRequest request) throws ProductException;
	
	public abstract CommandResult done(Player player,String ps[]) throws ProductException;
}
