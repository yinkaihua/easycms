package com.coding17.easycms.soa.dao.site.impl;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.site.TSiteDAO;
import com.coding17.easycms.soa.entity.site.TSite;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tSiteDAO")
public class TSiteDAOImpl extends SuperDAO<TSite> implements TSiteDAO {

	@Override
	protected String getStatementPrefix() {
		return TSite.class.getName();
	}

}