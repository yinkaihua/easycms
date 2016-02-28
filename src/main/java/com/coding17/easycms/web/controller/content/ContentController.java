package com.coding17.easycms.web.controller.content;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.entity.content.TContent;
import com.coding17.easycms.soa.entity.contentext.TContentExt;
import com.coding17.easycms.soa.service.channel.TChannelService;
import com.coding17.easycms.soa.service.content.TContentService;
import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.controller.channel.ChannelController;
import com.coding17.easycms.web.util.BeanConverter;
import com.coding17.easycms.web.util.DictProperties;
import com.coding17.easycms.web.util.SiteContext;
import com.coding17.easycms.web.util.TreeBuilder;
import com.coding17.easycms.web.util.WebConst;
import com.coding17.easycms.web.vo.channel.Channel;
import com.coding17.easycms.web.vo.content.Content;
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
		List<Content> cs = new ArrayList<Content>();
		List<Channel> channels = new ArrayList<Channel>();
		if (sid!=-1) {
			//已选择站点，查询站点下的所有文章
			TChannel c = BeanConverter.objectC(p.getChannel(), TChannel.class);
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
			request.setAttribute("treejson", JSONArray.fromObject(tree).toString());
		}
		request.setAttribute("contents", cs);
		request.setAttribute("channels", channels);
		
		return "content/content_view";
	}
	
	@RequestMapping("/to_add.htm")
	public String toAdd(Integer cid) {
		SiteContext.check(request.getSession());
		if (cid == null) {
			return error("未指定栏目");
		}
		//查询当前栏目
		TChannel para = new TChannel();
		para.setId(cid);
		TChannel t = tChannelService.getByPriKey(para);
		Channel c = BeanConverter.objectC(t, Channel.class);
		request.setAttribute("channel", c);
		return "content/content_info";
	}
	
	@RequestMapping("/save.htm")
	public String save() {
		LOG.info("=====>发布文章{}", p);
		SiteContext.check(request.getSession());
		//参数校验
		if (p.getChannel().getId()==null) {
			return error("参数错误：栏目ID为空");
		}
		if (p.getId()==null) {
			//保存文章
			TContent content = BeanConverter.objectC(p, TContent.class);
			TContentExt ext = BeanConverter.objectC(p.getContentExt(), TContentExt.class);
			TChannel channel = BeanConverter.objectC(p.getChannel(), TChannel.class);
			content.setContentExt(ext);
			content.setChannel(channel);
			content.setCreateTime(new Date());
			content.setPubState(Integer.parseInt(DictProperties.getNoPubState()));
			try {
				content = tContentService.createContent(content);
			} catch (Exception ex) {
				LOG.error("=====>发布文章失败，{}", p, ex);
			}
		} else {
			//编辑文章
			TContent content = BeanConverter.objectC(p, TContent.class);
			TContentExt ext = BeanConverter.objectC(p.getContentExt(), TContentExt.class);
			TChannel channel = BeanConverter.objectC(p.getChannel(), TChannel.class);
			content.setContentExt(ext);
			content.setChannel(channel);
			content.setPubState(Integer.parseInt(DictProperties.getNoPubState()));
			try {
				content = tContentService.updateContent(content);
			} catch (Exception ex) {
				LOG.error("=====>编辑文章失败，{}", p, ex);
			}
		}
		return list(p.getChannel().getId());
	}
	
	@RequestMapping("/to_edit.htm")
	public String toEdit() {
		LOG.info("=====>编辑文章{}", p);
		SiteContext.check(request.getSession());
		TContent para = new TContent();
		para.setId(p.getId());
		TContent tContent = tContentService.getInfoByPriKey(para);
		Content content = Content.fromEntity(tContent);
		request.setAttribute("contents", content);
		request.setAttribute("channel", content.getChannel());
		request.setAttribute("isEdit", "yes");
		return "content/content_info";
	}
	
	@RequestMapping("/list.htm")
	public String list(Integer cid) {
		SiteContext.check(request.getSession());
		TChannel c = new TChannel();
		c.setId(cid);
		TContent para = new TContent();
		para.setChannel(c);
		para.setOrderby("id desc");
		Pagination<TContent> pagination = tContentService.selectListInfoByPagination(para);	
		List<TContent> tContents = pagination.getDatas();
		
		List<Content> contents = new ArrayList<Content>();
		for (TContent tc : tContents) {
			contents.add(Content.fromEntity(tc));
		}
		request.setAttribute("contents", contents);
		request.setAttribute("cid", cid);
		return "content/content_list";
	}
	
	@RequestMapping("/remove")
	public String remove(Integer cid) {
		LOG.info("=====>删除文章{}", p);
		SiteContext.check(request.getSession());
		TContent para = new TContent();
		para.setId(p.getId());
		try {
			tContentService.deleteContent(para);
		} catch (Exception ex) {
			LOG.info("=====>删除文章失败，{}", p, ex);
		}
		return list(cid);
	}
}
