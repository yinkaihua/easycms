package com.coding17.easycms.soa.dao.dict.impl;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.dict.TDictDAO;
import com.coding17.easycms.soa.entity.dict.TDict;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tDictDAO")
public class TDictDAOImpl extends SuperDAO<TDict> implements TDictDAO {

	@Override
	protected String getStatementPrefix() {
		return TDict.class.getName();
	}

}