package com.coding17.easycms.web.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.soa.entity.menu.TMenu;
import com.coding17.easycms.soa.service.menu.TMenuService;
import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.base.BaseVo;

@RequestMapping("/main")
@Controller
public class MainController extends BaseController<BaseVo> {
	
	@Autowired
	private TMenuService tMenuService;
	
	@RequestMapping("/index")
	public String index() {
		Integer.parseInt("aa");
		return "main/main";
	}
	
	@RequestMapping("/center")
	public String center() {
		super.respContent = "Hello,This is Center Area.";
		return writeResponse();
	}
	
	@RequestMapping("/left")
	public String left() {
		TMenu para = new TMenu();
		tMenuService.selectListByCondition(para);
		return "main/menu";
	}
	
}
