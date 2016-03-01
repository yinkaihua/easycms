package com.coding17.easycms.soa.dao.channel.impl;

import java.util.List;

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

	@Override
	public List<TChannel> selectListInfoByPagination(TChannel tChannel) {
		return selectListByPagination(getStatementPrefix() + ".selectListInfoByPagination", tChannel);
	}

	@Override
	public Integer selectListInfoCountByCondition(TChannel tChannel) {
		return selectCountByCondition(getStatementPrefix() + ".selectListInfoByPagination-count", tChannel);
	}

}