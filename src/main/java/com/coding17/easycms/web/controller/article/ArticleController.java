package com.coding17.easycms.web.controller.article;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;

/**
 * 文章
 * @Title: ArticleController.java 
 * @Package com.coding17.easycms.controller.article 
 * @author yin.kh
 * @date 2016年1月21日 下午9:55:25
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController<Object> {

	@RequestMapping("/test")
	public String test() {
		respContent = "@@@@";
		return writeResponse();
	}
	
}
