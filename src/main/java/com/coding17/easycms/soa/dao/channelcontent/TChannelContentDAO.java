package com.coding17.easycms.soa.dao.channelcontent;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.entity.channelcontent.TChannelContent;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public interface TChannelContentDAO extends ISuperDAO<TChannelContent> {

	public Integer deleteByContentId(TChannelContent entity);
	
}