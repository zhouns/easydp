package com.sgepm.easydp.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.sgepm.easydp.common.persistence.IBaseDaoImpl;
import com.sgepm.easydp.system.dao.SysDictCodeDao;
import com.sgepm.easydp.system.entity.SysDictCode;

@Repository("sysDictCodeDaoImpl")
public class SysDictCodeDaoImpl extends IBaseDaoImpl<SysDictCode> implements SysDictCodeDao {

	@Override
	public List<SysDictCode> findDictByGrp(String groupCode) {
		String sql = "select t.`code`, t.`name`, t.f0, t.f1, t.f2, t.f3, t.f4 from sys_dict_code t where t.`group` = ? order by t.sort";
		return this.findBeanList(sql, groupCode);
	}

}
