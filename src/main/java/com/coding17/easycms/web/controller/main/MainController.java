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
import com.coding17.easycms.web.controller.menu.MenuController;
import com.coding17.easycms.web.util.DictProperties;
import com.coding17.easycms.web.vo.menu.Menu;

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
		para.setState(Integer.parseInt(DictProperties.getValidState()));
		List<TMenu> tMenus = tMenuService.selectListByCondition(para);
		List<Menu> menus = null;
		if (!CollectionUtils.isEmpty(tMenus)) {
			menus = MenuController.buildMenus(0, tMenus);
		}
		request.setAttribute("menus", menus);
		return "main/left";
	}
	
}
