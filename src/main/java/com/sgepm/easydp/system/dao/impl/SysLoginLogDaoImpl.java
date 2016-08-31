package com.sgepm.easydp.system.dao.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.IBaseDaoImpl;
import com.sgepm.easydp.system.dao.SysLoginLogDao;
import com.sgepm.easydp.system.entity.SysLoginLog;

@Repository("sysLoginLogDaoImpl")
public class SysLoginLogDaoImpl extends IBaseDaoImpl<SysLoginLog> implements SysLoginLogDao {

	@Override
	public Pagination findBeanPage(HttpServletRequest request) {
		String sql = "select t.id, t.uid, t.login_ip, t.login_time, t.login_origin from sys_login_log t order by t.login_time desc";
		return this.findBeanPageByReq(sql, request);
	}

}
