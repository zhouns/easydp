package com.sgepm.easydp.system.dao;

import java.util.List;
import java.util.Map;

import com.sgepm.easydp.common.persistence.IBaseDao;
import com.sgepm.easydp.system.entity.SysDBTable;

public interface SysDBTableDao extends IBaseDao<SysDBTable> {
	
	public List<Map<String, Object>> findDBList();
	
	public List<Map<String, Object>> findTableList(String dbName);
	
	public List<Map<String, Object>> findColumnList(String table);

}
