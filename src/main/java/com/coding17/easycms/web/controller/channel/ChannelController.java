package com.coding17.easycms.web.controller.channel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.exception.CmsWebException;
import com.coding17.easycms.web.util.BeanConverter;
import com.coding17.easycms.web.util.SiteContext;
import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.entity.site.TSite;
import com.coding17.easycms.soa.service.channel.TChannelService;
import com.coding17.easycms.soa.service.site.TSiteService;
import com.coding17.easycms.web.vo.channel.Channel;

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
	
	@Autowired
	private TSiteService tSiteService;
	
	@RequestMapping("/view")
	public String view() {
		TSite para = new TSite();
		para.setState(DictContainer.State.getValidState());
		List<TSite> sites = tSiteService.selectListByCondition(para);
		request.setAttribute("sites", sites);
		
		Integer siteId = null;
		if (p.getSiteId()!=null) {
			siteId = p.getSiteId();
		}
		if (siteId == null && SiteContext.get(request.getSession())!=null) {
			siteId = SiteContext.get(request.getSession()).getId();
		}
		
		//已选择站点, siteId==-1表示用户自己不选择站点
		if (siteId != null && siteId != -1) {
			TChannel c = new TChannel();
			c.setSiteId(siteId);
			List<TChannel> list = tChannelService.selectListByCondition(c);
//			List<Channel> channels = BeanConverter.listC(list, Channel.class);
			request.setAttribute("channels", buildChannels(0, list));
			
			SiteContext.set(request.getSession(), siteId);
			
			p.setSiteId(siteId);
			refreshP(p);
		} else {
			SiteContext.clear(request.getSession());
		}
		
		return "channel/channel_view";
	}
	
	@RequestMapping("/to_add")
	public String toAdd() {
		checkSite();
		return "channel/channel_info";
	}
	
	@RequestMapping("/to_edit")
	public String toEdit() {
		checkSite();
		TChannel para = new TChannel();
		para.setId(p.getId());
		TChannel tc = tChannelService.getByPriKey(para);
		Channel channel = BeanConverter.objectC(tc, Channel.class);
		request.setAttribute("so", channel);
		request.setAttribute("isEdit", "yes");
		return "channel/channel_info";
	}
	
	@RequestMapping("/save")
	public String save() {
		LOG.info("=====>保存栏目，{}", p);
		checkSite();
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
	
	@RequestMapping("/remove")
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
	
	private void checkSite() {
		if (SiteContext.get(request.getSession())==null) {
			throw new CmsWebException("未选择站点");
		}
	}
	
}
