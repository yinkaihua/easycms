package com.coding17.easycms.soa.dao.contentext.impl;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.contentext.TContentExtDAO;
import com.coding17.easycms.soa.entity.contentext.TContentExt;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tContentExtDAO")
public class TContentExtDAOImpl extends SuperDAO<TContentExt> implements TContentExtDAO {

	@Override
	protected String getStatementPrefix() {
		return TContentExt.class.getName();
	}

}