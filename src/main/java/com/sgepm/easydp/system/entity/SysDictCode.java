package com.sgepm.easydp.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysDictCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_dict_code", catalog = "easydp")
public class SysDictCode implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6437117631380457031L;
	private String id;
	private String code;
	private String name;
	private String group;
	private Integer sort;
	private String remark;
	private String f0;
	private String f1;
	private String f2;
	private String f3;
	private String f4;

	// Constructors

	/** default constructor */
	public SysDictCode() {
	}

	/** minimal constructor */
	public SysDictCode(String id, String code, String name, String group,
			Integer sort) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.group = group;
		this.sort = sort;
	}

	/** full constructor */
	public SysDictCode(String id, String code, String name, String group,
			Integer sort, String remark, String f0, String f1, String f2,
			String f3, String f4) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.group = group;
		this.sort = sort;
		this.remark = remark;
		this.f0 = f0;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
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

	@Column(name = "group", nullable = false, length = 32)
	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Column(name = "sort", nullable = false)
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "remark", length = 128)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "f0", length = 64)
	public String getF0() {
		return this.f0;
	}

	public void setF0(String f0) {
		this.f0 = f0;
	}

	@Column(name = "f1", length = 64)
	public String getF1() {
		return this.f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	@Column(name = "f2", length = 64)
	public String getF2() {
		return this.f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	@Column(name = "f3", length = 64)
	public String getF3() {
		return this.f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	@Column(name = "f4", length = 64)
	public String getF4() {
		return this.f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

}