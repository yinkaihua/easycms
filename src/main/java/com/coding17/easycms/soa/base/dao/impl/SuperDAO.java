package com.coding17.easycms.soa.base.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;

/**
 * ISuperDAO 实现类
 * @Title: SuperDAO.java 
 * @Package: com.coding17.easycms.soa.base.dao.impl  
 * @author: yin.kh
 * @date: 2016年1月25日 下午11:13:53
 */
/*@Repository*/
public abstract class SuperDAO<T> implements ISuperDAO<T> {

	private static final String statement_selectByPrimaryKey = "findByPriKey";
	
	private static final String statement_deleteByPrimaryKey = "deleteByPriKey";
	
	private static final String statement_insertSelective = "insert";
	
	private static final String statement_insert = "insert";
	
	private static final String statement_updateByPrimaryKeySelective = "update";
	
	private static final String statement_update = "updateBak";
	
	private static final String statement_selectListByCondition = "selectListByCondition";
	
	private static final String statement_selectListByPagination = "selectListByPagination";
	
	private static final String statement_selectCountByCondition = "selectCountByCondition";
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public T selectByPrimaryKey(T t) {
		return template.selectOne(getStatementPrefix() + "." + statement_selectByPrimaryKey, t);
	}

	@Override
	public Integer deleteByPrimaryKey(T t) {
		return template.delete(getStatementPrefix() + "." + statement_deleteByPrimaryKey, t);
	}

	@Override
	public Integer insertSelective(T t) {
		return template.insert(getStatementPrefix() + "." + statement_insertSelective, t);
	}

	@Override
	public Integer insert(T t) {
		return template.insert(getStatementPrefix() + "." + statement_insert, t);
	}

	@Override
	public Integer updateByPrimaryKeySelective(T t) {
		return template.update(getStatementPrefix() + "." + statement_updateByPrimaryKeySelective, t);
	}

	@Override
	public Integer update(T t) {
		return template.update(getStatementPrefix() + "." + statement_update, t);
	}
	
	@Override
	public List<T> selectListByCondition(T t) {
		return template.selectList(getStatementPrefix()+"."+statement_selectListByCondition, t);
	}

	@Override
	public List<T> selectListByPagination(T t) {
		return template.selectList(getStatementPrefix()+"."+statement_selectListByPagination, t);
	}

	@Override
	public Integer selectCountByCondition(T t) {
		return (Integer) template.selectOne(getStatementPrefix() + "." + statement_selectCountByCondition, t);
	}

	/**
	 * 子类必须重写此方法
	 * @return
	 */
	protected abstract String getStatementPrefix();

}