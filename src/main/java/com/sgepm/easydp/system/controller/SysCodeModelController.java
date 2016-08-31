package com.sgepm.easydp.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sgepm.easydp.common.web.BaseController;
import com.sgepm.easydp.system.manager.SysCodeModelManager;

@Controller
@RequestMapping(value = "/system/codemodel")
public class SysCodeModelController extends BaseController {
	
	@Autowired
	private SysCodeModelManager sysCodeModelManager;
	
	private final static String PAGE_PATH = "system/codemodel/";
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String init(Model model) {
		return PAGE_PATH + "index";
	}
}
