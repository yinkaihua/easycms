package com.coding17.easycms.web.util;

import javax.servlet.http.HttpSession;

import com.coding17.easycms.api.util.SpringBeanUtil;
import com.coding17.easycms.soa.entity.site.TSite;
import com.coding17.easycms.soa.service.site.TSiteService;
import com.coding17.easycms.web.vo.site.Site;

/**
 * 站点上下文信息
 * @Title: SiteContext
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年2月17日 下午4:39:38
 */
public class SiteContext {

	private static final String SITE_CONTEXT = "session_site_context";
	
	private static TSiteService service = SpringBeanUtil.getBean("tSiteService", TSiteService.class);
	
	public static void set(HttpSession session, Integer siteId) {
		Object obj = session.getAttribute(SITE_CONTEXT);
		if (obj!=null && ((Site)obj).getId()==siteId) {
			return;
		}
		TSite para = new TSite();
		para.setId(siteId);
		TSite tSite = service.getByPriKey(para);
		Site site = BeanConverter.objectC(tSite, Site.class);
		session.setAttribute(SITE_CONTEXT, site);
	}
	
	public static Site get(HttpSession session) {
		return (Site) session.getAttribute(SITE_CONTEXT);
	}
	
	public static void clear(HttpSession session) {
		session.removeAttribute(SITE_CONTEXT);
	}
	
}
