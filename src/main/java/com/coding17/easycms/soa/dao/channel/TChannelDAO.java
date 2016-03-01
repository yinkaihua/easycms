package com.coding17.easycms.soa.dao.channel;

import java.util.List;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public interface TChannelDAO extends ISuperDAO<TChannel> {

	/**
	 * 关联查询，内容，栏目
	 * @param tChannel
	 * @return
	 */
	public List<TChannel> selectListInfoByPagination(TChannel tChannel);
	
	/**
	 * 关联查询数量，用于分页
	 * @param tChannel
	 * @return
	 */
	public Integer selectListInfoCountByCondition(TChannel tChannel);
	
}