package com.sgepm.easydp.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgepm.easydp.common.web.BaseController;
import com.sgepm.easydp.system.entity.SysDBInfo;
import com.sgepm.easydp.system.entity.SysDBTable;
import com.sgepm.easydp.system.manager.SysDBTableManager;

@Controller
@RequestMapping(value = "/gen/db")
public class DBTableController extends BaseController {
	
	@Autowired
	private SysDBTableManager dBTableManager;
	
	//private final static String PAGE_PATH = "gen/db/";
	
	@ResponseBody
	@RequestMapping(value = "dblist", method = RequestMethod.GET)
	public List<SysDBInfo> dblist(Model model) {
		List<SysDBInfo> dbList = dBTableManager.findDBList();
		return dbList;
	}
	
	@ResponseBody
	@RequestMapping(value = "tblist", method = RequestMethod.GET)
	public List<SysDBTable> tblist(Model model, String dbName) {
		List<SysDBTable> tblist = dBTableManager.findTableList(dbName);
		return tblist;
	}
	
}
