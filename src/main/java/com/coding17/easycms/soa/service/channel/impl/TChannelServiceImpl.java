package com.coding17.easycms.soa.service.channel.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.dao.channel.TChannelDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.service.channel.TChannelService;

/**
 *
 * @Title: TChannelServiceImpl.java 
 * @Package: com.coding17.easycms.soa.service.channel.impl  
 * @author: yin.kh
 * @date: 2016年1月25日 下午11:50:52 
 */
@Repository("tChannelService")
public class TChannelServiceImpl implements TChannelService {

	@Autowired
	private TChannelDAO tChannelDAO;
	
	/**
	 * 创建栏目
	 */
	@Override
	public TChannel createChannel(TChannel channel) {
		channel.setCreateTime(new Date());
		tChannelDAO.insert(channel);
		return channel;
	}
}