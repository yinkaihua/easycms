package com.coding17.easycms.soa.service.dict.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.dict.TDictDAO;
import com.coding17.easycms.soa.service.dict.TDictService;
import com.coding17.easycms.soa.entity.dict.TDict;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tDictService")
public class TDictServiceImpl extends BaseServiceImpl<TDict> implements TDictService {
	
	@Autowired
	public TDictDAO tDictDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TDictServiceImpl.class);
	
	@Override
	protected ISuperDAO<TDict> getDao() {
		return tDictDao;
	}
	
}
