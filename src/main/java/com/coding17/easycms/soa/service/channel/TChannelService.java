package com.coding17.easycms.soa.service.channel;

import com.coding17.easycms.soa.entity.channel.TChannel;

/**
 * 栏目服务
 * @Title: TChannelService.java 
 * @Package: com.coding17.easycms.soa.service.channel  
 * @author: yin.kh
 * @date: 2016年1月25日 下午11:50:58
 */
public interface TChannelService {

	/**
	 * 创建栏目
	 * @param channel
	 * @return
	 */
	public TChannel createChannel(TChannel channel);
}
