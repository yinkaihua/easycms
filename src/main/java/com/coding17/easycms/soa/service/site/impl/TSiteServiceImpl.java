package com.coding17.easycms.soa.service.site.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.site.TSiteDAO;
import com.coding17.easycms.soa.service.site.TSiteService;
import com.coding17.easycms.soa.entity.site.TSite;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tSiteService")
public class TSiteServiceImpl extends BaseServiceImpl<TSite> implements TSiteService {
	
	@Autowired
	public TSiteDAO tSiteDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TSiteServiceImpl.class);
	
	@Override
	protected ISuperDAO<TSite> getDao() {
		return tSiteDao;
	}
	
}
