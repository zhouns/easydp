package com.sgepm.easydp.common.entity;

import java.util.List;
import java.util.Map;

public class TreeModel {
	
	private String id;
	private String text;
	private String type;
	private TreeState state;
	private Map<String, Object> li_attr;
	private Map<String, Object> a_attr;
	private List<TreeModel> children;
	
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public TreeState getState() {
		return state;
	}
	
	public void setState(TreeState state) {
		this.state = state;
	}
	
	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public Map<String, Object> getLi_attr() {
		return li_attr;
	}
	
	public void setLi_attr(Map<String, Object> li_attr) {
		this.li_attr = li_attr;
	}
	
	public Map<String, Object> getA_attr() {
		return a_attr;
	}
	
	public void setA_attr(Map<String, Object> a_attr) {
		this.a_attr = a_attr;
	}
	
}
