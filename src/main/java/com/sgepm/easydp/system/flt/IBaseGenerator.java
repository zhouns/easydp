package com.sgepm.easydp.system.flt;

import com.sgepm.easydp.common.utils.ConfigUtils;

public class IBaseGenerator {
	
	protected String entity;
	protected String moudel;
	protected String menu;
	protected String rootpackage;
	protected String lowerCaseEntity;
	
	public IBaseGenerator() {
		super();
	}

	public IBaseGenerator(String entity, String moudel, String menu,
			String lowerCaseEntity) {
		super();
		this.entity = entity;
		this.moudel = moudel;
		this.menu = menu;
		this.lowerCaseEntity = lowerCaseEntity;
	}
	
	public String getAbsProjectPath() {
		return ConfigUtils.getInstance().getProperty("project.abstractpath");
	}
	
	public String getAbsRootPkgPath() {
		String rootPackage = ConfigUtils.getInstance().getProperty("project.rootpackage");
		return getAbsProjectPath() + "/src/main/java/" + rootPackage.replaceAll("\\.", "/");
	}
	
	public void generaterCode() {}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getMoudel() {
		return moudel;
	}

	public void setMoudel(String moudel) {
		this.moudel = moudel;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public String getRootpackage() {
		rootpackage = ConfigUtils.getInstance().getProperty("project.rootpackage");
		return rootpackage;
	}

	public void setRootpackage(String rootpackage) {
		this.rootpackage = rootpackage;
	}

	public String getLowerCaseEntity() {
		return lowerCaseEntity;
	}

	public void setLowerCaseEntity(String lowerCaseEntity) {
		this.lowerCaseEntity = lowerCaseEntity;
	}
	
}
