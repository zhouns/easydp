package com.sgepm.easydp.system.manager.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sgepm.easydp.common.manager.IBaseManagerImpl;
import com.sgepm.easydp.system.dao.SysCodeModelDao;
import com.sgepm.easydp.system.entity.SysCodeModel;
import com.sgepm.easydp.system.manager.SysCodeModelManager;

@Service("sysCodeModelManagerImpl")
public class SysCodeModelManagerImpl extends IBaseManagerImpl<SysCodeModel> implements SysCodeModelManager {

	@Resource(name = "sysCodeModelDaoImpl")
	public void setDao(SysCodeModelDao dao) {
		this.dao = dao;
	}
	
	public SysCodeModelDao getDao() {
		return (SysCodeModelDao) super.getDao();
	}
	
}
