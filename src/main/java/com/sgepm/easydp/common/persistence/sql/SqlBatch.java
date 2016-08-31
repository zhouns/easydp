package com.sgepm.easydp.common.persistence.sql;

import java.util.List;

public class SqlBatch {

	private String sql;
	
	private List<Object[]> parameters;
	
	public SqlBatch() {
		super();
	}

	public SqlBatch(String sql, List<Object[]> parameters) {
		super();
		this.sql = sql;
		this.parameters = parameters;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<Object[]> getParameters() {
		return parameters;
	}

	public void setParameters(List<Object[]> parameters) {
		this.parameters = parameters;
	}
	
}
