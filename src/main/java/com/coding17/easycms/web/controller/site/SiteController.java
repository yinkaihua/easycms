package com.coding17.easycms.web.controller.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.soa.service.site.TSiteService;
import com.coding17.easycms.web.vo.site.Site;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@RequestMapping("/")
@Controller
public class SiteController extends BaseController<Site> {
	
	@Autowired
	private TSiteService tSiteService;
	
}
