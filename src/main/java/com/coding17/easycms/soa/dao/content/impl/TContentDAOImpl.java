package com.coding17.easycms.soa.dao.content.impl;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.content.TContentDAO;
import com.coding17.easycms.soa.entity.content.TContent;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tContentDAO")
public class TContentDAOImpl extends SuperDAO<TContent> implements TContentDAO {

	@Override
	protected String getStatementPrefix() {
		return TContent.class.getName();
	}

}