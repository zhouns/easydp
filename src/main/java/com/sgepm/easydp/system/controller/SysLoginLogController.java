package com.sgepm.easydp.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.sql.OrderBy;
import com.sgepm.easydp.common.web.BaseController;
import com.sgepm.easydp.system.entity.SysDictGroup;
import com.sgepm.easydp.system.manager.SysLoginLogManager;

@Controller
@RequestMapping(value = "/system/lglog")
public class SysLoginLogController extends BaseController {
	
	@Autowired
	private SysLoginLogManager sysLoginLogManager;
	
	private final static String PAGE_PATH = "system/lglog/";
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String init(Model model) {
		return PAGE_PATH + "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public Pagination list(HttpServletRequest request) {
		OrderBy orderBy = new OrderBy();
		Pagination pagination = sysLoginLogManager.findBeanPage(request);
		return pagination;
	}
	
}
