package com.sgepm.easydp.system.entity;

import javax.persistence.Table;

@Table
public class SysDBTableColumn implements java.io.Serializable {
	
	private static final long serialVersionUID = 5756029906704540345L;
	
	private String field;
	private String type;
	private String nullable;
	private String isKey;
	private String defaultVal;
	private String extra;
	
	public SysDBTableColumn() {
		super();
	}
	
	public SysDBTableColumn(String field) {
		super();
		this.field = field;
	}

	public SysDBTableColumn(String field, String type, String nullable,
			String isKey, String defaultVal, String extra) {
		super();
		this.field = field;
		this.type = type;
		this.nullable = nullable;
		this.isKey = isKey;
		this.defaultVal = defaultVal;
		this.extra = extra;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getIsKey() {
		return isKey;
	}

	public void setIsKey(String isKey) {
		this.isKey = isKey;
	}

	public String getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
}
