package com.sgepm.easydp.system.manager.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sgepm.easydp.common.manager.IBaseManagerImpl;
import com.sgepm.easydp.system.dao.SysCodeTmpDao;
import com.sgepm.easydp.system.entity.SysCodeTmp;
import com.sgepm.easydp.system.manager.SysCodeTmpManager;

@Service("sysCodeTmpManagerImpl")
public class SysCodeTmpManagerImpl extends IBaseManagerImpl<SysCodeTmp> implements SysCodeTmpManager {

	@Resource(name = "sysCodeTmpDaoImpl")
	public void setDao(SysCodeTmpDao dao) {
		this.dao = dao;
	}
	
	public SysCodeTmpDao getDao() {
		return (SysCodeTmpDao) super.getDao();
	}

	@Override
	public List<SysCodeTmp> findTmpList(String code) {
		return getDao().findTmpList(code);
	}
	
}
