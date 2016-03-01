package com.coding17.easycms.soa.service.channel.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.channel.TChannelDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.service.channel.TChannelService;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tChannelService")
public class TChannelServiceImpl extends BaseServiceImpl<TChannel> implements TChannelService {
	
	@Autowired
	public TChannelDAO tChannelDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TChannelServiceImpl.class);
	
	@Override
	protected ISuperDAO<TChannel> getDao() {
		return tChannelDao;
	}

	@Override
	public Pagination<TChannel> selectListInfoByPagination(TChannel tChannel) {
		//数据校验
		if (tChannel.getPageNum()==null || tChannel.getPageNum()<=0) {
			tChannel.setPageNum(Pagination.DEFAULT_PAGENUM);
		}
		if (tChannel.getPageSize()==null || tChannel.getPageSize()<=0 || tChannel.getPageSize()>Pagination.MAX_PAGESIZE) {
			tChannel.setPageSize(Pagination.DEFAULT_PAGESIZE);
		}
		List<TChannel> datas = tChannelDao.selectListInfoByPagination(tChannel);
		Integer totalCount = tChannelDao.selectListInfoCountByCondition(tChannel);
		Integer totalPage = (totalCount-1)/tChannel.getPageSize()+1;
		return new Pagination<>(tChannel.getPageNum(), tChannel.getPageSize(), totalCount, totalPage, datas);
	}
	
}
