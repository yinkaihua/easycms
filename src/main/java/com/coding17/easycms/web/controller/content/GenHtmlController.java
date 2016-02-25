package com.coding17.easycms.web.controller.content;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.vo.content.Content;

/**
 * 页面静态化 
 * @Title: GenHtmlController.java
 * @Package: com.coding17.easycms.web.controller.content
 * @author: yin.kh
 * @date: 2016年2月25日 下午10:04:57
 */
@Scope("prototype")
@RequestMapping("/gen")
@Controller
public class GenHtmlController extends BaseController<Content> {

}
