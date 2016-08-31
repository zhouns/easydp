package com.sgepm.easydp.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_DICT_GROUP", schema = "EASYDP")
public class SysDictGroup implements java.io.Serializable {
	
	private static final long serialVersionUID = -7257408586927435194L;
	private String code;
	private String name;
	private Short type;
	private String remark;
	
	public SysDictGroup() {
		super();
	}

	public SysDictGroup(String code) {
		super();
		this.code = code;
	}

	public SysDictGroup(String code, String name, Short type, String remark) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.remark = remark;
	}
	
	@Id
	@Column(name = "code", nullable = false, length = 32)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", nullable = false)
	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "remark", nullable = false, length = 128)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
