package com.ygxhj.mynetty.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jboss.netty.util.internal.ConcurrentHashMap;

import com.ygxhj.mynetty.core.dao.PlayerDAO;
import com.ygxhj.mynetty.core.dao.PlayerDAOImpl;
import com.ygxhj.mynetty.core.dao.ProductDAO;
import com.ygxhj.mynetty.core.dao.ProductDAOImpl;
import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.core.model.PlayerExample;
import com.ygxhj.mynetty.core.model.Product;
import com.ygxhj.mynetty.core.model.ProductExample;
import com.ygxhj.mynetty.dbutil.DBManager;

public class PlayerSet {

	private static final PlayerSet instance = new PlayerSet();

	private Logger log = Logger.getLogger(PlayerSet.class);
	private Map<Long, Player> playerSet = new ConcurrentHashMap<Long, Player>();
	
	private PlayerSet(){}
	public static PlayerSet getInstance() {
		return instance;
	}
	
	public Player getPlayer(long playerId){
		Player player = playerSet.get(playerId);
		if (player == null) {
			player = loadPlayerById(playerId);
			log.info("loadPlayerProduct begin");
			loadPlayerProduct(player);
			log.info("loadPlayerProduct end");
			
			if (player != null) {
				playerSet.put(player.getId(), player);
			}
		}
		player.setLastMessage(System.currentTimeMillis());
		return player;
	}
	
	public Player getCachPlayer(long playerId){
		return playerSet.get(playerId);
	}
	
	private Player loadPlayerById(long playerId){
		PlayerDAO dao = (PlayerDAO)DBManager.getDao(PlayerDAOImpl.class);
		PlayerExample example = new PlayerExample();
		example.createCriteria().andIdEqualTo(playerId);
		Player player = null;
		try {
			List<Player> list = dao.selectByExample(example);
			if (list != null && list.size() > 0) {
				player = list.get(0);
			}
		} catch (SQLException e) {
			log.error("loadPlayer exception :" , e);
		}
		return player;
	}
	
	private void loadPlayerProduct(Player player){
		
		ProductExample example = new ProductExample();
		example.createCriteria().andPlayerIdEqualTo(player.getId());
		ProductDAO dao = (ProductDAO) DBManager.getDao(ProductDAOImpl.class);
		try {
			List<Product> list = dao.selectByExample(example);
			for(Product p : list){
				player.getPlayerProduct().put(p.getId(), p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void cleanPlayer(){
		List<Long> offlinePlayer = new ArrayList<Long>();
		
		for (Player player : playerSet.values()) {
			if (System.currentTimeMillis() - player.getLastMessage() > Constants.TIMEOUT) {
				offlinePlayer.add(player.getId());
			}
		}
		for (long id : offlinePlayer) {
			playerSet.remove(id);
			log.info("clean player " + id);
		}
	}
	
}
