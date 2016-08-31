package com.sgepm.easydp.system.manager;

import java.util.List;
import com.sgepm.easydp.common.manager.IBaseManager;
import com.sgepm.easydp.system.entity.SysDictCode;

public interface SysDictCodeManager extends IBaseManager<SysDictCode> {

	List<SysDictCode> findDictByGrp(String groupCode);

}