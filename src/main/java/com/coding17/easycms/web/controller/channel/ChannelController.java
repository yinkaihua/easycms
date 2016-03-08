package com.coding17.easycms.web.controller.channel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.entity.content.TContent;
import com.coding17.easycms.soa.service.channel.TChannelService;
import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.util.BeanConverter;
import com.coding17.easycms.web.util.DictProperties;
import com.coding17.easycms.web.util.SiteContext;
import com.coding17.easycms.web.util.WebConst;
import com.coding17.easycms.web.vo.channel.Channel;
import com.coding17.easycms.web.vo.content.Content;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Scope(value="prototype")
@RequestMapping("/channel")
@Controller
public class ChannelController extends BaseController<Channel> {
	
	@Autowired
	private TChannelService tChannelService;
	
	@RequestMapping("/view.htm")
	public String view() {
		Integer sid = Integer.parseInt(request.getAttribute(WebConst.wc_a_req_sid).toString());
		if (sid!=-1) {
			TChannel c = new TChannel();
			c.setSiteId(sid);
			c.setOrderby("SORT ASC");
			List<TChannel> list = tChannelService.selectListByCondition(c);
			request.setAttribute("channels", buildChannels(0, list));
		}
		
		return "channel/channel_view";
	}
	
	@ResponseBody
	@RequestMapping("/children_list_ajax.htm")
	public Map<String, Object> getListByPid() {
		Map<String, Object> json = new HashMap<String, Object>();
		TChannel para = new TChannel();
		para.setPid(p.getPid());
		para.setOrderby("sort asc");
		try {
			List<TChannel> list = tChannelService.selectListByCondition(para);
			json.put("state", 0);
			json.put("data", list);
		} catch (Exception ex) {
			LOG.error("=====>查询子栏目失败，PID={}", p.getPid(), ex);
			json.put("state", 1);
		}
		return json;
	}
	
	@RequestMapping("/to_add.htm")
	public String toAdd() {
		SiteContext.check(request.getSession());
		if (p.getPid()!=null && p.getPid()!=0) {
			TChannel para = new TChannel();
			para.setId(p.getPid());
			TChannel c = tChannelService.getByPriKey(para);
			request.setAttribute("c", c);
		}
		return "channel/channel_info";
	}
	
	@RequestMapping("/to_edit.htm")
	public String toEdit() {
		SiteContext.check(request.getSession());
		TChannel para = new TChannel();
		para.setId(p.getId());
		TChannel tc = tChannelService.getByPriKey(para);
		p.setPid(tc.getPid());
		if (tc.getPid()!=0) {
			//查询父栏目
			para.setId(tc.getPid());
			request.setAttribute("c", tChannelService.getByPriKey(para));
		}
		Channel channel = BeanConverter.objectC(tc, Channel.class);
		request.setAttribute("so", channel);
		request.setAttribute("isEdit", "yes");
		return "channel/channel_info";
	}
	
	@RequestMapping("/save.htm")
	public String save() {
		LOG.info("=====>保存栏目，{}", p);
		SiteContext.check(request.getSession());
		TChannel para = BeanConverter.objectC(p, TChannel.class);
		if (p.getId()==null) {
			try {
				para.setSiteId(SiteContext.get(request.getSession()).getId());
				para.setCreateTime(new Date());
				tChannelService.create(para);
			} catch (Exception ex) {
				LOG.error("=====>保存栏目失败，{}", p, ex);
			}
		} else {
			try {
				tChannelService.update(para);
			} catch (Exception ex) {
				LOG.error("=====>更新栏目失败，{}", p, ex);
			}
		}
		return view();
	}
	
	@ResponseBody
	@RequestMapping("/has_children.htm")
	public Map<String, Object> hasChildren() {
		Map<String, Object> json = new HashMap<String, Object>();
		TChannel para = new TChannel();
		para.setPid(p.getId());
		List<TChannel> list = tChannelService.selectListByCondition(para);
		if (list.size()>0) {
			json.put("state", DictProperties.getFailJsonState());
			json.put("msg", "当前栏目存在子栏目");
		} else {
			json.put("state", DictProperties.getSuccessJsonState());
		}
		return json;
	}
	
	@RequestMapping("/remove.htm")
	public String remove() {
		LOG.info("=====>删除栏目，{}", p);
		TChannel para = new TChannel();
		para.setId(p.getId());
		try {
			tChannelService.deleteByPriKey(para);
		} catch (Exception ex) {
			LOG.error("=====>删除栏目失败，{}", p, ex);
		}
		return view();
	}
	
	@RequestMapping("/list.htm")
	public String list() {
		SiteContext.check(request.getSession());
		TChannel c = new TChannel();
		c.setPid(p.getPid());
		List<TChannel> tChannels = tChannelService.selectListByCondition(c);
		List<Channel> channels = BeanConverter.listC(tChannels, Channel.class);
		request.setAttribute("channels", channels);
		return "channel/channel_list";
	}
	
	public static List<Channel> buildChannels(int pid, List<TChannel> tChannels) {
		List<Channel> menus = new ArrayList<Channel>();
		for (TChannel tm : tChannels) {
			if (tm.getPid()==pid) {
				Channel m = BeanConverter.objectC(tm, Channel.class);
				if (m.getLevel()==1) {
					m.setSubChannel(buildChannels(m.getId(), tChannels));
				}
				menus.add(m);
			}
		}
		return menus;
	}
	
}
