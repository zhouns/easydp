package com.sgepm.easydp.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sgepm.easydp.common.entity.AjaxResult;
import com.sgepm.easydp.common.web.BaseController;
import com.sgepm.easydp.system.entity.SysCodeTmp;
import com.sgepm.easydp.system.entity.SysDBTableColumn;
import com.sgepm.easydp.system.flt.IBaseGenerator;
import com.sgepm.easydp.system.flt.JavaBeanGenerator;
import com.sgepm.easydp.system.flt.SkeletonGenerator;
import com.sgepm.easydp.system.manager.SysCodeTmpManager;
import com.sgepm.easydp.system.manager.SysDBTableManager;

@Controller
@RequestMapping(value = "/system/codegen")
public class SysCodeGenController extends BaseController {
	
	@Autowired
	private SysCodeTmpManager sysCodeTmpManager;
	@Autowired
	private SysDBTableManager sysDBTableManager;
	
	private final static String PAGE_PATH = "system/codegen/";
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String init(Model model) {
		return PAGE_PATH + "SysCodeGenIndex";
	}
	
	@RequestMapping(value = "steps", method = RequestMethod.GET)
	public String init(Model model, String code) {
		code = code.substring(0, 1).toUpperCase() + code.substring(1);
		return PAGE_PATH + "SysCodeGen" + code;
	}
	
	@ResponseBody
	@RequestMapping(value = "generater", method = RequestMethod.POST)
	public AjaxResult genCode(String tmpCode, String moudel, String menu, String schema, String tbName) {
		List<SysDBTableColumn> tableColumnList = sysDBTableManager.findTableInfo(tbName);
		List<SysCodeTmp> codeTempList = sysCodeTmpManager.findTmpList(tmpCode);
		
		// 创建Javabean
		JavaBeanGenerator beanGenerator = new JavaBeanGenerator(schema, tbName, moudel, menu, tableColumnList);
		String entityName = beanGenerator.createJavaBean();
		
		IBaseGenerator generator = null;
		if (tmpCode.equals("1")) {
			generator = new SkeletonGenerator(moudel, menu, entityName, codeTempList);
			generator.generaterCode();
		}
		return new AjaxResult();
	}
	
}
