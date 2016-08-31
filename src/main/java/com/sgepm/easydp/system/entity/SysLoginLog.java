package com.sgepm.easydp.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_login_log", schema = "easydp")
public class SysLoginLog implements java.io.Serializable {
	
	private String id;
	private String uid;
	private String loginIp;
	private String loginTime;
	private Short loginOrigin;

	
	public SysLoginLog() {
		super();
	}
	
	public SysLoginLog(String id) {
		this.id = id;
	}
	
	public SysLoginLog(String id, String uid, String loginIp, String loginTime, Short loginOrigin) {
		this.id = id;
		this.uid = uid;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.loginOrigin = loginOrigin;
	}
    
	@Id
	@Column(name="id", unique=true, nullable=false, length=36)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="uid", nullable=false, length=64)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name="login_ip", nullable=false, length=32)
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Column(name="login_time", nullable=false, length=32)
	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name="login_origin", nullable=false, precision=4, scale=0)
	public Short getLoginOrigin() {
		return loginOrigin;
	}

	public void setLoginOrigin(Short loginOrigin) {
		this.loginOrigin = loginOrigin;
	}


}

