package com.sgepm.easydp.system.manager;

import javax.servlet.http.HttpServletRequest;

import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.manager.IBaseManager;
import com.sgepm.easydp.system.entity.SysLoginLog;

public interface SysLoginLogManager extends IBaseManager<SysLoginLog> {

	public Pagination findBeanPage(HttpServletRequest request);

}