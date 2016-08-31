package com.sgepm.easydp.system.manager.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sgepm.easydp.common.manager.IBaseManagerImpl;
import com.sgepm.easydp.system.dao.SysDictCodeDao;
import com.sgepm.easydp.system.entity.SysDictCode;
import com.sgepm.easydp.system.manager.SysDictCodeManager;

@Service("sysDictCodeManagerImpl")
public class SysDictCodeManagerImpl extends IBaseManagerImpl<SysDictCode> implements SysDictCodeManager {

	@Resource(name = "sysDictCodeDaoImpl")
	public void setDao(SysDictCodeDao dao) {
		this.dao = dao;
	}
	
	public SysDictCodeDao getDao() {
		return (SysDictCodeDao) super.getDao();
	}

	@Override
	public List<SysDictCode> findDictByGrp(String groupCode) {
		return getDao().findDictByGrp(groupCode);
	}
	
}
