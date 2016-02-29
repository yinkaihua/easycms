package com.coding17.easycms.web.controller.site;

import java.util.ArrayList;
import java.util.Date;
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
	
	@RequestMapping("/view.htm")
	public String view() {
		TSite para = new TSite();
//		para.setState(DictContainer.State.getValidState());
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
	
	@RequestMapping("/to_add.htm")
	public String toAdd() {
		return "site/site_info";
	}
	
	@RequestMapping("/save.htm")
	public String save() {
		LOG.info("=====>保存站点，{}", p);
		TSite para = new TSite();
		BeanUtils.copyProperties(p, para);
		if (p.getId()==null) {
			para.setCreateTime(new Date());
			para.setAccount(1000);
			para.setAccountName("admin");
			try {
				tSiteService.create(para);
			} catch (Exception ex) {
				LOG.error("=====>创建站点失败，{}", p, ex);
			}
		} else {
			try {
				tSiteService.update(para);
			} catch (Exception ex) {
				LOG.error("=====>更新站点失败，{}", p, ex);
			}
		}
		return view();
	}
	
	@RequestMapping("/to_edit.htm")
	public String toEdit() {
		TSite para = new TSite();
		para.setId(p.getId());
		TSite site = tSiteService.getByPriKey(para);
		Site vo = new Site();
		BeanUtils.copyProperties(site, vo);
		request.setAttribute("so", vo);
		request.setAttribute("isEdit", "yes");
		return "site/site_info";
	}
	
	@RequestMapping("/remove.htm")
	public String remove() {
		LOG.info("=====>删除站点，{}", p);
		TSite para = new TSite();
		para.setId(p.getId());
		try {
			tSiteService.deleteByPriKey(para);
		} catch (Exception ex) {
			LOG.error("=====>删除站点失败，{}", p, ex);
		}
		return view();
	}
	
}
