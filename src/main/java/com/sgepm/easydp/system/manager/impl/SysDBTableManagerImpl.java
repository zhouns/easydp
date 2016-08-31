package com.sgepm.easydp.system.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sgepm.easydp.common.manager.IBaseManagerImpl;
import com.sgepm.easydp.common.utils.StringUtils;
import com.sgepm.easydp.system.dao.SysDBTableDao;
import com.sgepm.easydp.system.entity.SysDBInfo;
import com.sgepm.easydp.system.entity.SysDBTable;
import com.sgepm.easydp.system.entity.SysDBTableColumn;
import com.sgepm.easydp.system.manager.SysDBTableManager;

@Service("sysDBTableManagerImpl")
public class SysDBTableManagerImpl extends IBaseManagerImpl<SysDBTable> implements SysDBTableManager {

	@Resource(name = "sysDBTableDaoImpl")
	public void setDao(SysDBTableDao dao) {
		this.dao = dao;
	}
	
	public SysDBTableDao getDao() {
		return (SysDBTableDao) super.getDao();
	}

	@Override
	public List<SysDBInfo> findDBList() {
		List<SysDBInfo> dbInfoList = new ArrayList<SysDBInfo>();
		List<Map<String, Object>> list = getDao().findDBList();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			String dbName = StringUtils.objIsNullToStr(map.get("Database"));
			SysDBInfo dbInfo = new SysDBInfo(dbName);
			dbInfoList.add(dbInfo);
		}
		return dbInfoList;
	}

	@Override
	public List<SysDBTable> findTableList(String dbName) {
		List<SysDBTable> tableList = new ArrayList<SysDBTable>();
		List<Map<String, Object>> list = getDao().findTableList(dbName);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			SysDBTable table = new SysDBTable(
					StringUtils.objIsNullToStr(map.get("TABLE_CATALOG")),
					StringUtils.objIsNullToStr(map.get("TABLE_NAME")),
					StringUtils.objIsNullToStr(map.get("TABLE_TYPE")),
					StringUtils.objIsNullToStr(map.get("ENGINE")),
					StringUtils.objIsNullToStr(map.get("VERSION")),
					StringUtils.objIsNullToStr(map.get("ROW_FORMAT")),
					StringUtils.objIsNullToStr(map.get("TABLE_ROWS")),
					StringUtils.objIsNullToStr(map.get("AVG_ROW_LENGTH")),
					StringUtils.objIsNullToStr(map.get("DATA_LENGTH")),
					StringUtils.objIsNullToStr(map.get("MAX_DATA_LENGTH")),
					StringUtils.objIsNullToStr(map.get("INDEX_LENGTH")),
					StringUtils.objIsNullToStr(map.get("DATA_FREE")),
					StringUtils.objIsNullToStr(map.get("AUTO_INCREMENT")),
					StringUtils.objIsNullToStr(map.get("CREATE_TIME")),
					StringUtils.objIsNullToStr(map.get("UPDATE_TIME")),
					StringUtils.objIsNullToStr(map.get("CHECK_TIME")),
					StringUtils.objIsNullToStr(map.get("TABLE_COLLATION")),
					StringUtils.objIsNullToStr(map.get("CHECKSUM")),
					StringUtils.objIsNullToStr(map.get("CREATE_OPTIONS")),
					StringUtils.objIsNullToStr(map.get("TABLE_COMMENT")),
					StringUtils.objIsNullToStr(map.get("TABLE_SCHEMA")));
			tableList.add(table);
		}
		return tableList;
	}

	@Override
	public List<SysDBTableColumn> findTableInfo(String table) {
		List<SysDBTableColumn> columnList = new ArrayList<SysDBTableColumn>();
		List<Map<String, Object>> list = getDao().findColumnList(table);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			SysDBTableColumn column = new SysDBTableColumn(
					StringUtils.objIsNullToStr(map.get("Field")),
					StringUtils.objIsNullToStr(map.get("Type")),
					StringUtils.objIsNullToStr(map.get("Null")),
					StringUtils.objIsNullToStr(map.get("Key")),
					StringUtils.objIsNullToStr(map.get("Default")),
					StringUtils.objIsNullToStr(map.get("Extra")));
			columnList.add(column);
		}
		return columnList;
	}

}
