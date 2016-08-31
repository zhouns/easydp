package com.sgepm.easydp.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sgepm.easydp.common.web.BaseController;

@Controller
@RequestMapping(value = "/admin")
public class LoginController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initLogin(Model model) {
		return "system/login";
	}
	
	//@RequiresPermissions("oa:leave:view")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(RedirectAttributes redirectAttributes) {
		return "redirect:index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String adminIndex() {
		return "system/skeleton/index";
	}

}
