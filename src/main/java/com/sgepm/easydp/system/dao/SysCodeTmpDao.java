package com.sgepm.easydp.system.dao;

import java.util.List;

import com.sgepm.easydp.common.persistence.IBaseDao;
import com.sgepm.easydp.system.entity.SysCodeTmp;

public interface SysCodeTmpDao extends IBaseDao<SysCodeTmp> {

	public List<SysCodeTmp> findTmpList(String code);

}