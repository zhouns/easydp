package com.sgepm.easydp.common.persistence.validate;

public class ColumnDefine {
	
	private String column;
	
	private boolean nullable;
	
	private Integer length;
	
	private Integer precision;
	
	private Integer scale;
	
	public ColumnDefine() {
		super();
	}

	public ColumnDefine(String column, boolean nullable, Integer length,
			Integer precision, Integer scale) {
		super();
		this.column = column;
		this.nullable = nullable;
		this.length = length;
		this.precision = precision;
		this.scale = scale;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

}
