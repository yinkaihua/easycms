package com.coding17.easycms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.coding17.easycms.web.util.SiteContext;
import com.coding17.easycms.web.util.WebConst;

/**
 * 设置当前站点   _c_sid==null，当前未从下拉框选择，session中原来选择的站点；_c_sid==0，下拉框选择无，清除站点；_c_sid!=0，设置当前站点
 * @Title: SiteContextInterceptor
 * @Package: com.coding17.easycms.web.interceptor
 * @author: yin.kh
 * @date: 2016年2月23日 下午5:30:01
 */
public class SiteContextInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object _c_sid = request.getParameter(WebConst.wc_p_context_sid);
		if (_c_sid == null) {
			if (SiteContext.isSelected(request.getSession())) {
				request.setAttribute(WebConst.wc_a_req_sid, SiteContext.get(request.getSession()).getId());
			} else {
				request.setAttribute(WebConst.wc_a_req_sid, -1);
			}
		} else {
			Integer sid = Integer.parseInt(_c_sid.toString());
			if (sid == -1) {
				SiteContext.clear(request.getSession());
			} else {
				SiteContext.set(request.getSession(), sid);
			}
			request.setAttribute(WebConst.wc_a_req_sid, sid);
		}
		//用于站点下拉框
		SiteContext.setAllSitesToRequest(request);
		return super.preHandle(request, response, handler);
	}

}