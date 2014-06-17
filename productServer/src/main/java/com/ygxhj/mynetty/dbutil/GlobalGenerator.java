/**
 * 数据库递增逐渐产生器，用于一下几个表
 * */
package com.ygxhj.mynetty.dbutil;

import java.util.HashMap;
import java.util.Map;

public class GlobalGenerator {

	
	public long getReusedIdForNewObj(String tableName) {
		return getId(tableName);
	}

	public static final GlobalGenerator instance = new GlobalGenerator();

	public static GlobalGenerator getInstance() {
		return instance;
	}

	private static Map<String, IdGenerator> idMap = new HashMap<String, IdGenerator>();

	private GlobalGenerator() {
	}

	
	private long getId(String tabelName) {
		IdGenerator idGenerator = idMap.get(tabelName);
		if (idGenerator == null) {
			synchronized (tabelName.intern()) {
				idGenerator = idMap.get(tabelName);
				if (idGenerator == null) {
					idGenerator = new IdGenerator();
					idGenerator.setTableName(tabelName);
					int maxId = DBService.getOperaThread().getMaxId(tabelName);
					long seqno = (maxId == -1 ? 1 : maxId + 1);
					idGenerator.setSeqno(seqno);
					idMap.put(tabelName, idGenerator);
				}
			}
		}

		synchronized (idGenerator) {
			long id = idGenerator.getSeqno();
			id++;
			idGenerator.setSeqno(id);
			return id;
		}
	}
}
