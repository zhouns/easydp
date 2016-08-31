package com.sgepm.easydp.common.entity;

public class TreeState {
	
	//是否打开状态
    private boolean opened;
    
    //是否可用状态
    private boolean disabled;
    
    //是否选中状态
    private boolean selected;

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
