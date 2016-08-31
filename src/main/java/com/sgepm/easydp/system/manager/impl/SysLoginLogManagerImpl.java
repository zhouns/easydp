package com.sgepm.easydp.system.manager.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.manager.IBaseManagerImpl;
import com.sgepm.easydp.system.dao.SysLoginLogDao;
import com.sgepm.easydp.system.entity.SysLoginLog;
import com.sgepm.easydp.system.manager.SysLoginLogManager;

@Service("sysLoginLogManagerImpl")
public class SysLoginLogManagerImpl extends IBaseManagerImpl<SysLoginLog> implements SysLoginLogManager {

	@Resource(name = "sysLoginLogDaoImpl")
	public void setDao(SysLoginLogDao dao) {
		this.dao = dao;
	}
	
	public SysLoginLogDao getDao() {
		return (SysLoginLogDao) super.getDao();
	}

	@Override
	public Pagination findBeanPage(HttpServletRequest request) {
		return getDao().findBeanPage(request);
	}
	
}
