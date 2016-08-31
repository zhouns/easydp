package com.sgepm.easydp.common.persistence;

import javax.persistence.Column;

/**
 * 基础实体类
 * 
 * @author Nan
 *
 */
public class IBaseEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = -8241301387181203061L;

	private String tCreateBy;
	
	private String tCreateTime;
	
	private String tUpdateBy;
	
	private String tUpdateTime;
	
	private String tRemark;
	
	public IBaseEntity() {
		super();
	}

	public IBaseEntity(String tCreateBy, String tCreateTime, String tUpdateBy,
			String tUpdateTime, String tRemark) {
		super();
		this.tCreateBy = tCreateBy;
		this.tCreateTime = tCreateTime;
		this.tUpdateBy = tUpdateBy;
		this.tUpdateTime = tUpdateTime;
		this.tRemark = tRemark;
	}

	@Column(name = "T_CREATE_BY", nullable = false, length = 64)
	public String gettCreateBy() {
		return tCreateBy;
	}

	public void settCreateBy(String tCreateBy) {
		this.tCreateBy = tCreateBy;
	}

	@Column(name = "T_CREATE_TIME", nullable = false)
	public String gettCreateTime() {
		return tCreateTime;
	}

	public void settCreateTime(String tCreateTime) {
		this.tCreateTime = tCreateTime;
	}

	@Column(name = "T_UPDATE_BY", nullable = false, length = 64)
	public String gettUpdateBy() {
		return tUpdateBy;
	}

	public void settUpdateBy(String tUpdateBy) {
		this.tUpdateBy = tUpdateBy;
	}

	@Column(name = "T_UPDATE_TIME", nullable = false)
	public String gettUpdateTime() {
		return tUpdateTime;
	}

	public void settUpdateTime(String tUpdateTime) {
		this.tUpdateTime = tUpdateTime;
	}

	@Column(name = "T_REMARK", nullable = false, length = 128)
	public String gettRemark() {
		return tRemark;
	}

	public void settRemark(String tRemark) {
		this.tRemark = tRemark;
	}
	
}
