package com.sgepm.easydp.common.entity;

import javax.persistence.Table;

@Table
public class TreeEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1571960562503090861L;
	
	private String id;
	private String text;
	private String pid;
	private Integer type;
	private Integer sort;
	private String icon;
	private String url;
	
	public TreeEntity() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
