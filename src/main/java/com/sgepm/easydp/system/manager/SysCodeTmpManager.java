package com.sgepm.easydp.system.manager;

import java.util.List;

import com.sgepm.easydp.common.manager.IBaseManager;
import com.sgepm.easydp.system.entity.SysCodeTmp;

public interface SysCodeTmpManager extends IBaseManager<SysCodeTmp> {

	public List<SysCodeTmp> findTmpList(String code);

}