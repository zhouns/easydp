package com.sgepm.easydp.system.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.sgepm.easydp.common.persistence.IBaseDaoImpl;
import com.sgepm.easydp.system.dao.SysDBTableDao;
import com.sgepm.easydp.system.entity.SysDBTable;

@Repository("sysDBTableDaoImpl")
public class SysDBTableDaoImpl extends IBaseDaoImpl<SysDBTable> implements SysDBTableDao {
	
	/**
	 * 查询所有数据库
	 * @return
	 */
	public List<Map<String, Object>> findDBList() {
		return this.findMapList("show databases");
	}
	
	/**
	 * 查询数据库中所有表
	 * @return
	 */
	public List<Map<String, Object>> findTableList(String dbName) {
		String sql = "SELECT " +
						"information_schema.`TABLES`.TABLE_CATALOG, " +
						"information_schema.`TABLES`.TABLE_NAME, " +
						"information_schema.`TABLES`.TABLE_TYPE, " +
						"information_schema.`TABLES`.`ENGINE`, " +
						"information_schema.`TABLES`.VERSION, " +
						"information_schema.`TABLES`.ROW_FORMAT, " +
						"information_schema.`TABLES`.TABLE_ROWS, " +
						"information_schema.`TABLES`.AVG_ROW_LENGTH, " +
						"information_schema.`TABLES`.DATA_LENGTH, " +
						"information_schema.`TABLES`.MAX_DATA_LENGTH, " +
						"information_schema.`TABLES`.INDEX_LENGTH, " +
						"information_schema.`TABLES`.DATA_FREE, " +
						"information_schema.`TABLES`.AUTO_INCREMENT, " +
						"information_schema.`TABLES`.CREATE_TIME, " +
						"information_schema.`TABLES`.UPDATE_TIME, " +
						"information_schema.`TABLES`.CHECK_TIME, " +
						"information_schema.`TABLES`.TABLE_COLLATION, " +
						"information_schema.`TABLES`.`CHECKSUM`, " +
						"information_schema.`TABLES`.CREATE_OPTIONS, " +
						"information_schema.`TABLES`.TABLE_COMMENT, " +
						"information_schema.`TABLES`.TABLE_SCHEMA " +
					"FROM " +
						"INFORMATION_SCHEMA. TABLES " +
					"WHERE " +
						"TABLE_SCHEMA =?";
		return this.findMapList(sql, dbName);
	}
	
	/**
	 * 查询某表的所有属性
	 * @return
	 */
	public List<Map<String, Object>> findColumnList(String table) {
		return this.findMapList("show columns from " + table);
	}
}
