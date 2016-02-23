package com.coding17.easycms.soa.service.contentext.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.contentext.TContentExtDAO;
import com.coding17.easycms.soa.service.contentext.TContentExtService;
import com.coding17.easycms.soa.entity.contentext.TContentExt;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tContentExtService")
public class TContentExtServiceImpl extends BaseServiceImpl<TContentExt> implements TContentExtService {
	
	@Autowired
	public TContentExtDAO tContentExtDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TContentExtServiceImpl.class);
	
	@Override
	protected ISuperDAO<TContentExt> getDao() {
		return tContentExtDao;
	}
	
}
