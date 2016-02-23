package com.coding17.easycms.soa.dao.channelcontent.impl;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.channelcontent.TChannelContentDAO;
import com.coding17.easycms.soa.entity.channelcontent.TChannelContent;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tChannelContentDAO")
public class TChannelContentDAOImpl extends SuperDAO<TChannelContent> implements TChannelContentDAO {

	@Override
	protected String getStatementPrefix() {
		return TChannelContent.class.getName();
	}

}