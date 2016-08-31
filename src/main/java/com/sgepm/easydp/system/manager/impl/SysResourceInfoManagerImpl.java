package com.sgepm.easydp.system.manager.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sgepm.easydp.common.manager.IBaseManagerImpl;
import com.sgepm.easydp.system.dao.SysResourceInfoDao;
import com.sgepm.easydp.system.entity.SysResourceInfo;
import com.sgepm.easydp.system.manager.SysResourceInfoManager;

@Service("sysResourceInfoManagerImpl")
public class SysResourceInfoManagerImpl extends IBaseManagerImpl<SysResourceInfo> implements SysResourceInfoManager {

	@Resource(name = "sysResourceInfoDaoImpl")
	public void setDao(SysResourceInfoDao dao) {
		this.dao = dao;
	}
	
	public SysResourceInfoDao getDao() {
		return (SysResourceInfoDao) super.getDao();
	}
	
}
