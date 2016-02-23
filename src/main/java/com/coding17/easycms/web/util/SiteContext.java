package com.coding17.easycms.web.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.api.util.SpringBeanUtil;
import com.coding17.easycms.soa.entity.site.TSite;
import com.coding17.easycms.soa.service.site.TSiteService;
import com.coding17.easycms.web.exception.CmsWebException;
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
	
	/**
	 * 设置当前站点
	 * @param session
	 * @param siteId
	 */
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
	
	/**
	 * 检查站点是否已选择，未选择抛出异常
	 * @param session
	 */
	public static void check(HttpSession session) {
		if (!isSelected(session)) {
			throw new CmsWebException("未选择站点");
		}
	}
	
	/**
	 * 是否已选择站点
	 * @param session
	 * @return
	 */
	public static boolean isSelected(HttpSession session) {
		return get(session)!=null;
	}
	
	/**
	 * 获取当前站点
	 * @param session
	 * @return
	 */
	public static Site get(HttpSession session) {
		return (Site) session.getAttribute(SITE_CONTEXT);
	}
	
	/**
	 * 清除上下文
	 * @param session
	 */
	public static void clear(HttpSession session) {
		session.removeAttribute(SITE_CONTEXT);
	}
	
	public static void setAllSitesToRequest(HttpServletRequest request) {
		TSite para = new TSite();
		para.setState(DictContainer.State.getValidState());
		para.setOrderby("id asc");
		List<TSite> sites = service.selectListByCondition(para);
		request.setAttribute(WebConst.wc_a_req_allsites, sites);
	}
	
}
