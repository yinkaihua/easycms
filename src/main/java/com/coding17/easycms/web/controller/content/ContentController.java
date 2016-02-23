package com.coding17.easycms.web.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.soa.service.content.TContentService;
import com.coding17.easycms.web.vo.content.Content;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Scope("prototype")
@RequestMapping("/content")
@Controller
public class ContentController extends BaseController<Content> {
	
	@Autowired
	private TContentService tContentService;
	
	@RequestMapping("/view")
	public String view() {
		return "content/content_view";
	}
	
}
