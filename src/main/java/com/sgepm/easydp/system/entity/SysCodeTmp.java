package com.sgepm.easydp.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysCodeTmp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_code_tmp", catalog = "easydp")
public class SysCodeTmp implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870191767334126801L;
	private String id;
	private String name;
	private String modelId;
	private Integer type;
	private String codeSnippets;
	private Integer tier;
	private String remark;
	private String suffix;
	private String path;

	// Constructors

	/** default constructor */
	public SysCodeTmp() {
	}

	/** minimal constructor */
	public SysCodeTmp(String id, String name, String modelId, Integer type) {
		this.id = id;
		this.name = name;
		this.modelId = modelId;
		this.type = type;
	}

	/** full constructor */
	public SysCodeTmp(String id, String name, String modelId, Integer type,
			String codeSnippets, Integer tier, String remark) {
		this.id = id;
		this.name = name;
		this.modelId = modelId;
		this.type = type;
		this.codeSnippets = codeSnippets;
		this.tier = tier;
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

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "model_id", nullable = false, length = 36)
	public String getModelId() {
		return this.modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "code_snippets", length = 65535)
	public String getCodeSnippets() {
		return this.codeSnippets;
	}

	public void setCodeSnippets(String codeSnippets) {
		this.codeSnippets = codeSnippets;
	}

	@Column(name = "tier")
	public Integer getTier() {
		return this.tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	@Column(name = "remark", length = 128)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}