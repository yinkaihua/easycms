package com.coding17.easycms.soa.service.menu.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.menu.TMenuDAO;
import com.coding17.easycms.soa.service.menu.TMenuService;
import com.coding17.easycms.soa.entity.menu.TMenu;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tMenuService")
public class TMenuServiceImpl extends BaseServiceImpl<TMenu> implements TMenuService {
	
	@Autowired
	public TMenuDAO tMenuDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TMenuServiceImpl.class);
	
	@Override
	protected ISuperDAO<TMenu> getDao() {
		return tMenuDao;
	}
	
}
