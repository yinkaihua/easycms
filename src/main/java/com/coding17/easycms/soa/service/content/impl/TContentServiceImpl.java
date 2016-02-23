package com.coding17.easycms.soa.service.content.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.content.TContentDAO;
import com.coding17.easycms.soa.service.content.TContentService;
import com.coding17.easycms.soa.entity.content.TContent;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tContentService")
public class TContentServiceImpl extends BaseServiceImpl<TContent> implements TContentService {
	
	@Autowired
	public TContentDAO tContentDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TContentServiceImpl.class);
	
	@Override
	protected ISuperDAO<TContent> getDao() {
		return tContentDao;
	}
	
}
