package com.coding17.easycms.soa.dao.menu.impl;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.menu.TMenuDAO;
import com.coding17.easycms.soa.entity.menu.TMenu;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tMenuDAO")
public class TMenuDAOImpl extends SuperDAO<TMenu> implements TMenuDAO {

	@Override
	protected String getStatementPrefix() {
		return TMenu.class.getName();
	}

}