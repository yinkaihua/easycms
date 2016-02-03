package com.coding17.easycms.web.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.soa.service.menu.TMenuService;
import com.coding17.easycms.web.vo.menu.Menu;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@RequestMapping("/")
@Controller
public class MenuController extends BaseController<Menu> {
	
	@Autowired
	private TMenuService tMenuService;
	
}
