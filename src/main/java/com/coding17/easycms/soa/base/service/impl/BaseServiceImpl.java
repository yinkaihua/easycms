package com.coding17.easycms.soa.base.service.impl;

import java.util.List;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.entity.BasicEntity;
import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.base.service.BaseService;

/**
 * 基础service实现类
 * @Title: BaseServiceImpl
 * @Package: com.coding17.easycms.soa.base.service.impl
 * @author: yin.kh
 * @date: 2016年2月2日 下午6:04:01
 * @param <T>
 */
public abstract class BaseServiceImpl<T extends BasicEntity> implements BaseService<T> {
	
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

	@Override
	public List<T> selectListByCondition(T t) {
		return getDao().selectListByCondition(t);
	}

	@Override
	public Pagination<T> selectListByPagination(T t) {
		//数据校验
		if (t.getPageNum()<=0) {
			t.setPageNum(Pagination.DEFAULT_PAGENUM);
		}
		if (t.getPageSize()<=0 || t.getPageSize()>Pagination.MAX_PAGESIZE) {
			t.setPageSize(Pagination.DEFAULT_PAGESIZE);
		}
		List<T> datas = getDao().selectListByPagination(t);
		Integer totalCount = getDao().selectCountByCondition(t);
		Integer totalPage = (totalCount-1)/t.getPageSize()+1;
		return new Pagination<>(t.getPageNum(), t.getPageSize(), totalCount, totalPage, datas);
	}

	@Override
	public Integer selectCountByCondition(T t) {
		return getDao().selectCountByCondition(t);
	}

}
