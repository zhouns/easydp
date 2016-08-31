package com.sgepm.easydp.system.dao;

import javax.servlet.http.HttpServletRequest;

import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.IBaseDao;
import com.sgepm.easydp.system.entity.SysLoginLog;

public interface SysLoginLogDao extends IBaseDao<SysLoginLog> {

	public Pagination findBeanPage(HttpServletRequest request);

}