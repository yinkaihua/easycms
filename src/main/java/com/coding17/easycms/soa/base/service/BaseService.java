package com.coding17.easycms.soa.base.service;

/**
 * 基础service，提供基本的增删改查
 * @Title: BaseService
 * @Package: com.coding17.easycms.soa.base.service
 * @author: yin.kh
 * @date: 2016年2月2日 下午5:58:12
 * @param <T>
 */
public interface BaseService<T> {

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
	
}
