package com.coding17.easycms.web.controller.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.soa.entity.menu.TMenu;
import com.coding17.easycms.soa.service.menu.TMenuService;
import com.coding17.easycms.web.vo.menu.Menu;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Scope(value="prototype")
@RequestMapping("/menu")
@Controller
public class MenuController extends BaseController<Menu> {
	
	@Autowired
	private TMenuService tMenuService;
	
	@RequestMapping("/view")
	public String view() {
		TMenu para = new TMenu();
		para.setState(DictContainer.State.getValidState());
		para.setOrderby("sort asc");
		List<TMenu> tMenus = tMenuService.selectListByCondition(para);
		List<Menu> menus = null;
		if (!CollectionUtils.isEmpty(tMenus)) {
			menus = buildMenus(0, tMenus);
		}
		request.setAttribute("menus", menus);
		return "menu/view";
	}
	
	@RequestMapping("/add")
	public String add() {
		LOG.info("=====>添加菜单，{}", p);
		TMenu tMenu = new TMenu();
		BeanUtils.copyProperties(p, tMenu);
		tMenuService.create(tMenu);
		return view();
	}
	
	@RequestMapping("/remove")
	public String remove() {
		LOG.info("=====>删除菜单，{}", p);
		TMenu tMenu = new TMenu();
		tMenu.setPid(p.getId());
		//有子菜单先删除子菜单
		List<TMenu> subMenus = tMenuService.selectListByCondition(tMenu);
		for (TMenu t : subMenus) {
			LOG.info("=====>删除子菜单，{}", t);
			tMenuService.deleteByPriKey(t);
		}
		tMenu.setId(p.getId());
		tMenuService.deleteByPriKey(tMenu);
		return view();
	}
	
	public static List<Menu> buildMenus(int pid, List<TMenu> tMenus) {
		List<Menu> menus = new ArrayList<Menu>();
		for (TMenu tm : tMenus) {
			if (tm.getPid()==pid) {
				Menu m = new Menu();
				BeanUtils.copyProperties(tm, m);
				if (m.getLevel()==1) {
					m.setSubMenus(buildMenus(m.getId(), tMenus));
				}
				menus.add(m);
			}
		}
		return menus;
	}
}
