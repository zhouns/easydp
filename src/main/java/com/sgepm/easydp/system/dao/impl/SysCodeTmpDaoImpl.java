package com.sgepm.easydp.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.sgepm.easydp.common.persistence.IBaseDaoImpl;
import com.sgepm.easydp.system.dao.SysCodeTmpDao;
import com.sgepm.easydp.system.entity.SysCodeTmp;

@Repository("sysCodeTmpDaoImpl")
public class SysCodeTmpDaoImpl extends IBaseDaoImpl<SysCodeTmp> implements SysCodeTmpDao {

	@Override
	public List<SysCodeTmp> findTmpList(String code) {
		String sql = "SELECT " +
			"t1.id, " +
			"t1.`name`, " +
			"t1.type, " +
			"t1.code_snippets, " +
			"t1.tier, " +
			"t2.f0 suffix, " +
			"t2.f1 path " +
		"FROM " +
			"sys_code_tmp t1, " +
			"sys_dict_code t2 " +
		"WHERE " +
			"t1.tier = t2.`code` " +
		"AND t2.`group` = 'CODE_TIER' " +
		"AND t1.model_id = ?";
		return this.findBeanList(sql, code);
	}

}
