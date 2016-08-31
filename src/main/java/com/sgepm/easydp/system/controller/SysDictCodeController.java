package com.sgepm.easydp.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sgepm.easydp.common.web.BaseController;
import com.sgepm.easydp.system.entity.SysDictCode;
import com.sgepm.easydp.system.manager.SysDictCodeManager;

@Controller
@RequestMapping(value = "/system/dictcode")
public class SysDictCodeController extends BaseController {
	
	@Autowired
	private SysDictCodeManager sysDictCodeManager;
	
	private final static String PAGE_PATH = "system/dictcode/";
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String init(Model model) {
		List<SysDictCode> list = sysDictCodeManager.findDictByGrp("");
		return PAGE_PATH + "index";
	}
}
