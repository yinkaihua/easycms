package com.coding17.easycms.web.controller.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.controller.channel.ChannelController;
import com.coding17.easycms.web.util.WebConst;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.service.channel.TChannelService;
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
	
	@Autowired
	private TChannelService tChannelService;
	
	@RequestMapping("/view")
	public String view() {
		Integer sid = Integer.parseInt(request.getAttribute(WebConst.wc_a_req_sid).toString());
		if (sid!=-1) {
			TChannel c = new TChannel();
			c.setSiteId(sid);
			List<TChannel> list = tChannelService.selectListByCondition(c);
			request.setAttribute("channels", ChannelController.buildChannels(0, list));
		}
		
		return "content/content_view";
	}
	
}
