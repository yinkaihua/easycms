package com.coding17.easycms.web.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.soa.entity.menu.TMenu;
import com.coding17.easycms.soa.service.menu.TMenuService;
import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.base.BaseVo;

@Scope(value="prototype")
@RequestMapping("/main")
@Controller
public class MainController extends BaseController<BaseVo> {
	
	@Autowired
	private TMenuService tMenuService;
	
	@RequestMapping("/index")
	public String index() {
		//Integer.parseInt("aa");
		return "main/main";
	}
	
	@RequestMapping("/center")
	public String center() {
		respContent = "Hello,This is Center Area.";
		return writeResponse();
	}
	
	@RequestMapping("/left")
	public String left() {
		TMenu para = new TMenu();
		para.setState(DictContainer.State.getValidState());
		List<TMenu> menus = tMenuService.selectListByCondition(para);
		if (!CollectionUtils.isEmpty(menus)) {
			
		}
		request.setAttribute("menus", menus);
		return "main/menu";
	}
	
}
