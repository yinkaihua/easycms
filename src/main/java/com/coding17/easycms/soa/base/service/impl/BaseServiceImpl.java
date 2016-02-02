package com.coding17.easycms.soa.base.service.impl;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.service.BaseService;

/**
 * 基础service实现类
 * @Title: BaseServiceImpl
 * @Package: com.coding17.easycms.soa.base.service.impl
 * @author: yin.kh
 * @date: 2016年2月2日 下午6:04:01
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected abstract ISuperDAO<T> getDao();
	
	@Override
	public T create(T t) {
		getDao().insert(t);
		return t;
	}

	@Override
	public T deleteByPriKey(T t) {
		getDao().deleteByPrimaryKey(t);
		return t;
	}

	@Override
	public T getByPriKey(T t) {
		T e = getDao().selectByPrimaryKey(t);
		return e;
	}

	@Override
	public T update(T t) {
		getDao().updateByPrimaryKeySelective(t);
		return t;
	}

}
