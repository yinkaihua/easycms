package com.coding17.easycms.soa.dao.channel.impl;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.channel.TChannelDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tChannelDAO")
public class TChannelDAOImpl extends SuperDAO<TChannel> implements TChannelDAO {

	@Override
	protected String getStatementPrefix() {
		return TChannel.class.getName();
	}

}