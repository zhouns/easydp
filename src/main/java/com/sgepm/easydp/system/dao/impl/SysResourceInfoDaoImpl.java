package com.sgepm.easydp.system.dao.impl;

import org.springframework.stereotype.Repository;
import com.sgepm.easydp.common.persistence.IBaseDaoImpl;
import com.sgepm.easydp.system.dao.SysResourceInfoDao;
import com.sgepm.easydp.system.entity.SysResourceInfo;

@Repository("sysResourceInfoDaoImpl")
public class SysResourceInfoDaoImpl extends IBaseDaoImpl<SysResourceInfo> implements SysResourceInfoDao {

}
