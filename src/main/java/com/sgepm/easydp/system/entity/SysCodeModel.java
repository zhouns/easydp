package com.sgepm.easydp.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysCodeModel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_code_model", catalog = "easydp")
public class SysCodeModel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8899026153455325106L;
	private String id;
	private String code;
	private String name;
	private String remark;

	// Constructors

	/** default constructor */
	public SysCodeModel() {
	}

	/** minimal constructor */
	public SysCodeModel(String id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	/** full constructor */
	public SysCodeModel(String id, String code, String name, String remark) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false, length = 32)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "remark", length = 128)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}