package com.ygxhj.mynetty.task;

import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.ygxhj.mynetty.core.PlayerSet;

public class CleanTask {

	private Timer timer = new Timer();
	public CleanTask() {}

	/**
	 * 计时器启动
	 * 每分钟清理一次
	 */
	public void start() {
		GregorianCalendar calendar = new GregorianCalendar();
		timer.schedule(new TimerTask() {
			public void run() {
				try {
					PlayerSet.getInstance().cleanPlayer();
				} catch (Exception e) {
				}
			}
		}, calendar.getTime(), 1 * 1000);
	}
	
}
