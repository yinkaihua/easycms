package com.coding17.easycms.soa.service.channel.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.dao.channel.TChannelDAO;
import com.coding17.easycms.soa.service.channel.TChannelService;
import com.coding17.easycms.soa.entity.channel.TChannel;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository
public class TChannelServiceImpl implements TChannelService {
	
	@Autowired
	public TChannelDAO tChannelDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TChannelServiceImpl.class);
	
}
