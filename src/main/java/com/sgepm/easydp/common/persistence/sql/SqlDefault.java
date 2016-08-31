package com.sgepm.easydp.common.persistence.sql;

public class SqlDefault {
	
	private String sql;
	
	private Object[] parameters;
	
	public SqlDefault() {
	}

	public SqlDefault(String sql, Object[] parameters) {
		this.sql = sql;
		this.parameters = parameters;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
	
}
