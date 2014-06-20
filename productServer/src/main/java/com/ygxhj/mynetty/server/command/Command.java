package com.ygxhj.mynetty.server.command;

import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.exception.ProductException;
import com.ygxhj.mynetty.message.CommandRequest;
import com.ygxhj.mynetty.message.CommandResult;

public abstract class Command {

	protected static final String PARAM_COMMAND_NAME = "cmd";
	protected static final String PARAM_USER_ID = "uid";
	protected static final String PARAM_PLAYER_ID = "pid";
	protected static final String PARAM_PASSWORD = "password";
	protected static final String PARAM = "param";
	
	public abstract CommandResult exec(CommandRequest request) throws ProductException;
	
	public abstract CommandResult done(Player player,String ps[]) throws ProductException;
}
