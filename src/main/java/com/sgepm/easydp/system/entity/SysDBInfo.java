package com.sgepm.easydp.system.entity;

import javax.persistence.Table;

@Table
public class SysDBInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = -5892787490647173679L;
	
	private String dbName;

	public SysDBInfo() {
		super();
	}

	public SysDBInfo(String dbName) {
		super();
		this.dbName = dbName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
}
