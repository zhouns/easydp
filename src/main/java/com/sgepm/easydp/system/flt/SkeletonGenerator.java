package com.sgepm.easydp.system.flt;

import java.util.List;
import com.sgepm.easydp.system.entity.SysCodeTmp;

public class SkeletonGenerator extends IBaseGenerator {
	
	private List<SysCodeTmp> codeTempList;
	
	public SkeletonGenerator(String moudel, String menu, String entity, List<SysCodeTmp> codeTempList) {
		super();
		this.menu = menu;
		this.moudel = moudel;
		this.entity = entity;
		this.lowerCaseEntity = entity.substring(0, 1).toLowerCase() + entity.substring(1);
		this.codeTempList = codeTempList;
	}
	
	@Override
	public void generaterCode() {
		for (int i = 0; i < codeTempList.size(); i++) {
			SysCodeTmp codeTemplate = codeTempList.get(i);
			String path = codeTemplate.getPath();
			String suffix = codeTemplate.getSuffix();
			String fltPath = "skeleton/Skeleton" + suffix.replace("java", "flt");
			String absGenPath = getAbsRootPkgPath() + "/" + moudel + "/"+ path +"/" + entity + suffix;
			if (codeTemplate.getTier() == 5) {
				fltPath = "skeleton/Skeleton" + suffix.replace("jsp", "flt");
				absGenPath = getAbsProjectPath() + "/src/main/webapp/WEB-INF/views/"+ moudel +"/" + menu +"/"+ entity + suffix;
			}
			FreemarkEngine.write(fltPath, absGenPath, this);
		}
	}
	
}
