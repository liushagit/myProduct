package com.ygxhj.mynetty.core.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.core.model.PlayerExample;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public PlayerDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public Integer insert(Player record) throws SQLException {
		Object newKey = sqlMapClient.insert("player.abatorgenerated_insert",
				record);
		return (Integer) newKey;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public int updateByPrimaryKey(Player record) throws SQLException {
		int rows = sqlMapClient.update(
				"player.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public int updateByPrimaryKeySelective(Player record) throws SQLException {
		int rows = sqlMapClient.update(
				"player.abatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	@SuppressWarnings("unchecked")
	public List<Player> selectByExample(PlayerExample example)
			throws SQLException {
		List<Player> list = (List<Player>) sqlMapClient.queryForList(
				"player.abatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public Player selectByPrimaryKey(Integer id) throws SQLException {
		Player key = new Player();
		key.setId(id);
		Player record = (Player) sqlMapClient.queryForObject(
				"player.abatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public int deleteByExample(PlayerExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"player.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public int deleteByPrimaryKey(Integer id) throws SQLException {
		Player key = new Player();
		key.setId(id);
		int rows = sqlMapClient.delete(
				"player.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public int countByExample(PlayerExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"player.abatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public int updateByExampleSelective(Player record, PlayerExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"player.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	public int updateByExample(Player record, PlayerExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"player.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table player
	 * @abatorgenerated  Fri Jun 13 18:12:27 CST 2014
	 */
	private static class UpdateByExampleParms extends PlayerExample {
		private Object record;

		public UpdateByExampleParms(Object record, PlayerExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}