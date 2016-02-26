package com.coding17.easycms.web.controller.content;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding17.easycms.soa.entity.content.TContent;
import com.coding17.easycms.soa.service.content.TContentService;
import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.util.BeanConverter;
import com.coding17.easycms.web.util.DictProperties;
import com.coding17.easycms.web.util.FileUtil;
import com.coding17.easycms.web.util.JsonUtil;
import com.coding17.easycms.web.util.SiteContext;
import com.coding17.easycms.web.util.VelocityUtil;
import com.coding17.easycms.web.util.WebConst;
import com.coding17.easycms.web.vo.channel.Channel;
import com.coding17.easycms.web.vo.content.Content;
import com.coding17.easycms.web.vo.site.Site;

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
public class StaticPageController extends BaseController<Content> {

	@Autowired
	private TContentService tContentService;
	
	@ResponseBody
	@RequestMapping("/statiz.htm")
	public Map<String, Object> staticContents(String ids) {
		LOG.error("=====>生成静态页 {}", ids);
		SiteContext.check(request.getSession());
		Map<String, String> result = new HashMap<String, String>();
		for (String id : ids.split(",")) {
			TContent para = new TContent();
			para.setId(Integer.parseInt(id));
			TContent tContent = tContentService.getInfoByPriKey(para);
			if (tContent == null) {
				result.put(id, "生成失败，文章不存在");
				continue;
			}
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("title", tContent.getTitle());
			context.put("txt", tContent.getContentExt().getTxt());
			String html = VelocityUtil.genHtml(context, "content.vm");
			try {
				FileUtil.write(getFilePath(SiteContext.get(request.getSession()),
						BeanConverter.objectC(tContent.getChannel(), Channel.class),
						BeanConverter.objectC(tContent, Content.class)), html);
				para = new TContent();
				para.setId(Integer.parseInt(id));
				para.setPubState(Integer.parseInt(DictProperties.getAlreadyPubState()));
				tContentService.update(para);
			} catch (Exception ex) {
				result.put(id, "生成失败，"+ex.getMessage());
			}
		}
		
		return JsonUtil.getSuccJsonResult(result);
	}
	
	private static String getFilePath(Site site, Channel channel, Content content) {
		String path = WebConst.wc_webapp_root_path + site.getPath() + "\\" + channel.getPath() + "\\";
		path += DateFormatUtils.format(content.getCreateTime(), "yyyyMMdd")+content.getId()+".html";
		return path;
	}
}
