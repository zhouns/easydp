package com.sgepm.easydp.system.manager;

import java.util.List;
import com.sgepm.easydp.common.manager.IBaseManager;
import com.sgepm.easydp.system.entity.SysDBInfo;
import com.sgepm.easydp.system.entity.SysDBTable;
import com.sgepm.easydp.system.entity.SysDBTableColumn;

public interface SysDBTableManager extends IBaseManager<SysDBTable> {
	
	public List<SysDBInfo> findDBList();
	
	public List<SysDBTable> findTableList(String dbName);
	
	public List<SysDBTableColumn> findTableInfo(String table);

}
