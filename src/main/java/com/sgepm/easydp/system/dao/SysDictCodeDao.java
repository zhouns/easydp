package com.sgepm.easydp.system.dao;

import java.util.List;

import com.sgepm.easydp.common.persistence.IBaseDao;
import com.sgepm.easydp.system.entity.SysDictCode;

public interface SysDictCodeDao extends IBaseDao<SysDictCode> {

	List<SysDictCode> findDictByGrp(String groupCode);

}