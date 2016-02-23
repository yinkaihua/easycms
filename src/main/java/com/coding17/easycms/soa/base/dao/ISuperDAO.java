package com.coding17.easycms.soa.base.dao;

import java.util.List;

import com.coding17.easycms.soa.base.entity.BasicEntity;

/**
 * 所有dao的基类，提供基本的增删改查
 * @Title: ISuperDAO.java 
 * @Package: com.coding17.easycms.soa.base.dao  
 * @author: yin.kh
 * @date: 2016年1月23日 下午10:27:41
 */
public interface ISuperDAO<T extends BasicEntity> {

	/**
	 * 根据主键查询
	 * @param t
	 * @return
	 */
	T selectByPrimaryKey(T t);
	
	/**
	 * 根据主键删除
	 * @param t
	 * @return
	 */
	Integer deleteByPrimaryKey(T t);
	
	/**
	 * 插入数据，空字段不插入
	 * @param t
	 * @return
	 */
	Integer insertSelective(T t);
	
	/**
	 * 插入全部字段
	 * @param t
	 * @return
	 */
	Integer insert(T t);
	
	/**
	 * 更新，空字段不更新
	 * @param t
	 * @return
	 */
	Integer updateByPrimaryKeySelective(T t);
	
	/**
	 * 全部更新
	 * @param t
	 * @return
	 */
	Integer update(T t);
	
	/**
	 * 条件查询
	 * @param t
	 * @return
	 */
	List<T> selectListByCondition(T t);
	
	/**
	 * 分页查询
	 * @param t
	 * @return
	 */
	List<T> selectListByPagination(T t);
	
	/**
	 * 数量查询
	 * @param t
	 * @return
	 */
	Integer selectCountByCondition(T t);
	
	/**
	 * 自定义分页查询
	 * @param statement
	 * @param t
	 * @return
	 */
	List<T> selectListByPagination(String statement, T t);
	
	/**
	 * 自定义数量查询
	 * @param statement
	 * @param t
	 * @return
	 */
	Integer selectCountByCondition(String statement, T t);
}
