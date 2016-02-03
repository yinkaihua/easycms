package com.coding17.easycms.web.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 基础controller
 * @Title: BaseController.java 
 * @Package com.coding17.easycms.base.mvc 
 * @author yin.kh
 * @date 2016年1月21日 下午9:55:01
 */
public class BaseController<P extends BaseVo> {

	protected static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 请求对象
	 */
	protected HttpServletRequest request;
	
	/**
	 * 响应对象
	 */
	protected HttpServletResponse response;
	
	/**
	 * 响应内容
	 */
	protected String respContent;
	
	/**
	 * 参数对象
	 */
	protected P p;
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request, HttpServletResponse response, P p) {
		this.request = request;
		this.response = response;
		this.p = p;
		this.request.setAttribute("p", p);   //参数回传
	}
	
	protected String writeResponse() {
		if (respContent==null) {
			respContent = "";
		}
		try {
			response.getWriter().println(respContent);
		} catch (IOException e) {
			LOG.error("返回信息失败==>", e);
		}
		return null;
	}
	
}
