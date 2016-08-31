package com.sgepm.easydp.common.persistence.sql;

/**
 * 字段排序
 * 
 * @author Nan
 *
 */
public class OrderBy {
	
	StringBuffer orderBySQL = new StringBuffer();

	public synchronized OrderBy asc(String field) {
		before();
		orderBySQL.append(field).append(" ASC");
		return this;
	}

	public synchronized OrderBy desc(String field) {
		before();
		orderBySQL.append(field).append(" DESC");		
		return this;
	}
	
	private void before() {
		if (orderBySQL.length() == 0)  {
			orderBySQL.append("ORDER BY ");
		} else {
			orderBySQL.append(", ");
		}
	}
	
	public String asSQL() {
		return orderBySQL.toString();
	}
	
}
