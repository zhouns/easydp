package com.sgepm.easydp.common.entity;

public class AjaxResult {
	
	private boolean status = true;
	
	private String message;
	
	public AjaxResult() {}

	public AjaxResult(boolean status, String message1) {
		this.status = status;
		this.message = message1;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
