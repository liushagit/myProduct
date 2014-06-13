package com.ygxhj.mynetty.core.model;

import com.ygxhj.mynetty.core.BaseObject;
import java.util.Date;

public class Player extends BaseObject {
    /**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column player.id
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	private Integer id;

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column player.name
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	private String name;

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column player.create_time
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	private Date createTime;

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column player.login_time
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	private Date loginTime;

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column player.password
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	private String password;

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column player.group
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	private Integer group;

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column player.id
	 * @return  the value of player.id
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column player.id
	 * @param id  the value for player.id
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column player.name
	 * @return  the value of player.name
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column player.name
	 * @param name  the value for player.name
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column player.create_time
	 * @return  the value of player.create_time
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column player.create_time
	 * @param createTime  the value for player.create_time
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column player.login_time
	 * @return  the value of player.login_time
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column player.login_time
	 * @param loginTime  the value for player.login_time
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column player.password
	 * @return  the value of player.password
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column player.password
	 * @param password  the value for player.password
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column player.group
	 * @return  the value of player.group
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public Integer getGroup() {
		return group;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column player.group
	 * @param group  the value for player.group
	 * @abatorgenerated  Fri Jun 13 17:50:30 CST 2014
	 */
	public void setGroup(Integer group) {
		this.group = group;
	}

	public static String TABLE_NAME = "player";
    
    private long lastMessage;

	public long getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(long lastMessage) {
		this.lastMessage = lastMessage;
	}
}