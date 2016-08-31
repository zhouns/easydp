package com.sgepm.easydp.system.manager.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sgepm.easydp.common.manager.IBaseManagerImpl;
import com.sgepm.easydp.system.dao.SysDictGroupDao;
import com.sgepm.easydp.system.entity.SysDictGroup;
import com.sgepm.easydp.system.manager.SysDictGroupManager;

@Service("tSysDictIndexManagerImpl")
public class SysDictGroupManagerImpl extends IBaseManagerImpl<SysDictGroup> implements SysDictGroupManager {

	@Resource(name = "sysDictIndexDaoImpl")
	public void setDao(SysDictGroupDao dao) {
		this.dao = dao;
	}
	
	public SysDictGroupDao getDao() {
		return (SysDictGroupDao) super.getDao();
	}
	
}
