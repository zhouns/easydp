package com.sgepm.easydp.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sgepm.easydp.common.entity.AjaxResult;
import com.sgepm.easydp.common.entity.Pagination;
import com.sgepm.easydp.common.persistence.sql.OrderBy;
import com.sgepm.easydp.common.web.BaseController;
import com.sgepm.easydp.common.web.Constants;
import com.sgepm.easydp.system.entity.SysDictGroup;
import com.sgepm.easydp.system.manager.SysDictGroupManager;

@Controller
@RequestMapping(value = "/admin/dict")
public class SysDictGroupController extends BaseController {
	
	@Autowired
	private SysDictGroupManager sysDictGroupManager;
	
	private final static String PAGE_PATH = "system/dictionary/";
	
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String init(Model model) {
		return PAGE_PATH + "list";
	}
	
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Pagination list(HttpServletRequest request, SysDictGroup searchParams) {
		OrderBy orderBy = new OrderBy();
		Pagination dictGroupPage = sysDictGroupManager.findBeanPage(request, searchParams, orderBy.asc("name"));
		return dictGroupPage;
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model, String operation, String id) {
		if (Constants.CREATE.equals(operation)) {
			
		}
		
		if (Constants.UPDATE.equals(operation) || Constants.VIEW.equals(operation)) {
			SysDictGroup sysDictGroup = sysDictGroupManager.findBean(new SysDictGroup(id));
			model.addAttribute("sysDictGroup", sysDictGroup);
		}
		model.addAttribute("operation", operation);
		return PAGE_PATH + "edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public AjaxResult create(SysDictGroup sysDictGroup) {
		boolean unique = validUnique(sysDictGroup.getCode());
		if (!unique) {
			return new AjaxResult(false, "编码'" + sysDictGroup.getCode() + "'已经存在.");
		}
		boolean status = sysDictGroupManager.save(sysDictGroup);
		return new AjaxResult(status, null);
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public AjaxResult update(SysDictGroup sysDictGroup) {
		boolean status = sysDictGroupManager.update(sysDictGroup);
		return new AjaxResult(status, null);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public AjaxResult delete(SysDictGroup sysDictGroup) {
		int size = sysDictGroupManager.delete(sysDictGroup);
		return new AjaxResult((size == 1), null);
	}
	
	public boolean validUnique(String id) {
		OrderBy orderBy = new OrderBy();
		List<SysDictGroup> sysDictGroupList = sysDictGroupManager.findBeanList(new SysDictGroup(id), orderBy.asc("name"));
		if (!sysDictGroupList.isEmpty()) {
			return false;
		}
		return true;
	}
	
}
