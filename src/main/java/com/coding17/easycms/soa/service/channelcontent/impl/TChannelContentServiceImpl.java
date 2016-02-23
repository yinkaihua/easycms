package com.coding17.easycms.soa.service.channelcontent.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.channelcontent.TChannelContentDAO;
import com.coding17.easycms.soa.service.channelcontent.TChannelContentService;
import com.coding17.easycms.soa.entity.channelcontent.TChannelContent;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tChannelContentService")
public class TChannelContentServiceImpl extends BaseServiceImpl<TChannelContent> implements TChannelContentService {
	
	@Autowired
	public TChannelContentDAO tChannelContentDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TChannelContentServiceImpl.class);
	
	@Override
	protected ISuperDAO<TChannelContent> getDao() {
		return tChannelContentDao;
	}
	
}
