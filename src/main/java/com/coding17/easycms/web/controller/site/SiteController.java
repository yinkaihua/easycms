package com.coding17.easycms.web.controller.site;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.soa.entity.site.TSite;
import com.coding17.easycms.soa.service.site.TSiteService;
import com.coding17.easycms.web.vo.site.Site;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Scope("prototype")
@RequestMapping("/site")
@Controller
public class SiteController extends BaseController<Site> {
	
	@Autowired
	private TSiteService tSiteService;
	
	public String view() {
		TSite para = new TSite();
		para.setState(DictContainer.State.getValidState());
		List<TSite> list = tSiteService.selectListByCondition(para);
		List<Site> sites = new ArrayList<Site>();
		for (TSite s : list) {
			Site site = new Site();
			BeanUtils.copyProperties(s, site);
			sites.add(site);
		}
		request.setAttribute("sites", sites);
		return "site/site_view";
	}
	
}
