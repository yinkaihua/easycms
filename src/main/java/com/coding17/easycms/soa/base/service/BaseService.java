package com.coding17.easycms.soa.base.service;

import java.util.List;

import com.coding17.easycms.soa.base.entity.BasicEntity;
import com.coding17.easycms.soa.base.pager.Pagination;

/**
 * 基础service，提供基本的增删改查
 * @Title: BaseService
 * @Package: com.coding17.easycms.soa.base.service
 * @author: yin.kh
 * @date: 2016年2月2日 下午5:58:12
 * @param <T>
 */
public interface BaseService<T extends BasicEntity> {

	/**
	 * 创建
	 * @param t
	 * @return
	 */
	public T create(T t);
	
	/**
	 * 主键删除
	 * @param t
	 * @return
	 */
	public T deleteByPriKey(T t);
	
	/**
	 * 主键查询
	 * @param t
	 * @return
	 */
	public T getByPriKey(T t);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public T update(T t);
	
	/**
	 * 条件查询
	 * @param t
	 * @return
	 */
	public List<T> selectListByCondition(T t);
	
	/**
	 * 分页查询
	 * @param t
	 * @return
	 */
	public Pagination<T> selectListByPagination(T t);
	
	/**
	 * 数量查询
	 * @param t
	 * @return
	 */
	public Integer selectCountByCondition(T t);
	
}
