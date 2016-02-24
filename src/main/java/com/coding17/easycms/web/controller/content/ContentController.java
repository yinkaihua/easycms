package com.coding17.easycms.web.controller.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.entity.content.TContent;
import com.coding17.easycms.soa.service.channel.TChannelService;
import com.coding17.easycms.soa.service.content.TContentService;
import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.controller.channel.ChannelController;
import com.coding17.easycms.web.exception.CmsWebException;
import com.coding17.easycms.web.util.SiteContext;
import com.coding17.easycms.web.util.TreeBuilder;
import com.coding17.easycms.web.util.WebConst;
import com.coding17.easycms.web.vo.channel.Channel;
import com.coding17.easycms.web.vo.content.Content;
import com.coding17.easycms.web.vo.site.Site;
import com.coding17.easycms.web.vo.tree.TreeNode;

import net.sf.json.JSONArray;

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
		/*if (sid!=-1) {
			TChannel c = new TChannel();
			c.setSiteId(sid);
			List<TChannel> list = tChannelService.selectListByCondition(c);
			request.setAttribute("channels", ChannelController.buildChannels(0, list));
		}*/
		List<Content> cs = new ArrayList<Content>();
		List<Channel> channels = new ArrayList<Channel>();
		if (sid!=-1) {
			//已选择站点，查询站点下的所有文章
			TChannel c = new TChannel();
			c.setSiteId(sid);
			TContent p = new TContent();
			p.setChannel(c);
			List<TContent> list = tContentService.selectListByCondition(p);
			for (TContent t : list) {
				cs.add(Content.fromEntity(t));
			}
			
			c = new TChannel();
			c.setSiteId(sid);
			List<TChannel> channelList = tChannelService.selectListByCondition(c);
			channels = ChannelController.buildChannels(0, channelList);
			List<TreeNode> tree = TreeBuilder.build(channels, Channel.class, new String[] {"id","name","","","","level","subChannel"});
			request.setAttribute("tree", tree);
			request.setAttribute("treejson", JSONArray.fromObject(tree).toString());
		}
		request.setAttribute("contents", cs);
		request.setAttribute("channels", channels);
		
		return "content/content_view";
	}
	
	@RequestMapping("/to_add")
	public String toAdd() {
		if (!SiteContext.isSelected(request.getSession())) {
			throw new CmsWebException("未选择站点");
		}
		Site site = SiteContext.get(request.getSession());
		TChannel para = new TChannel();
		para.setSiteId(site.getId());
		para.setOrderby("sort asc");
		List<TChannel> list = tChannelService.selectListByCondition(para);
		List<Channel> channels = new ArrayList<Channel>();
		for (TChannel c : list) {
			channels.add(Channel.fromEntity(c));
		}
		request.setAttribute("channels", channels);
		return "content/content_info";
	}
	
	@ResponseBody
	@RequestMapping("/list_ajax")
	public Map<String, Object> listAjax() {
		Map<String, Object> json = new HashMap<String, Object>();
		System.out.println(p);
		return json;
	}
}
