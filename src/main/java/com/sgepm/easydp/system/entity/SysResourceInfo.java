package com.sgepm.easydp.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_resource_info", schema = "easydp")
public class SysResourceInfo implements java.io.Serializable {
	
	private String id;
	private String type;
	private String name;
	private Double size;
	private String sizeConver;
	private String webPath;
	private String localPath;
	private String uploadTime;
	private String uploadPerson;
	private String description;

	
	public SysResourceInfo() {
		super();
	}
	
	public SysResourceInfo(String id) {
		this.id = id;
	}
	
	public SysResourceInfo(String id, String type, String name, Double size, String sizeConver, String webPath, String localPath, String uploadTime, String uploadPerson, String description) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.size = size;
		this.sizeConver = sizeConver;
		this.webPath = webPath;
		this.localPath = localPath;
		this.uploadTime = uploadTime;
		this.uploadPerson = uploadPerson;
		this.description = description;
	}
    
	@Id
	@Column(name="id", unique=true, nullable=false, length=36)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="type", nullable=false, length=32)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="name", nullable=false, length=128)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="size", precision=16, scale=2)
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column(name="size_conver", length=16)
	public String getSizeConver() {
		return sizeConver;
	}

	public void setSizeConver(String sizeConver) {
		this.sizeConver = sizeConver;
	}

	@Column(name="web_path", length=256)
	public String getWebPath() {
		return webPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}

	@Column(name="local_path", length=256)
	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	@Column(name="upload_time", length=19)
	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name="upload_person", length=64)
	public String getUploadPerson() {
		return uploadPerson;
	}

	public void setUploadPerson(String uploadPerson) {
		this.uploadPerson = uploadPerson;
	}

	@Column(name="description", length=512)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}

