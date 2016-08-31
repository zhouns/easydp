package com.sgepm.easydp.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sgepm.easydp.common.web.BaseController;

@Controller
@RequestMapping(value = "/admin/welcome")
public class WelcomeController extends BaseController {
	
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String init(Model model) {
		return "system/skeleton/welcome";
	}
	
}
