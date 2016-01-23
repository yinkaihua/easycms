package com.coding17.easycms.soa.base.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;

public class SuperDAO<T> implements ISuperDAO<T> {

	private static final String statement_selectByPrimaryKey = "selectByPrimaryKey";
	
	private static final String statement_deleteByPrimaryKey = "deleteByPrimaryKey";
	
	private static final String statement_insertSelective = "insertSelective";
	
	private static final String statement_insert = "insert";
	
	private static final String statement_updateByPrimaryKeySelective = "updateByPrimaryKeySelective";
	
	private static final String statement_update = "update";
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public T selectByPrimaryKey(T t) {
		return template.selectOne(getStatementPrefix(t) + "." + statement_selectByPrimaryKey, t);
	}

	@Override
	public Integer deleteByPrimaryKey(T t) {
		return template.delete(getStatementPrefix(t) + "." + statement_deleteByPrimaryKey, t);
	}

	@Override
	public Integer insertSelective(T t) {
		return template.insert(getStatementPrefix(t) + "." + statement_insertSelective, t);
	}

	@Override
	public Integer insert(T t) {
		return template.insert(getStatementPrefix(t) + "." + statement_insert, t);
	}

	@Override
	public Integer updateByPrimaryKeySelective(T t) {
		return template.update(getStatementPrefix(t) + "." + statement_updateByPrimaryKeySelective, t);
	}

	@Override
	public Integer update(T t) {
		return template.update(getStatementPrefix(t) + "." + statement_update, t);
	}
	
	private String getStatementPrefix(T t) {
		return t.getClass().getName() + ".";
	}
	
	public static void main(String[] args) {
		TChannel c = new TChannel();
		System.out.println(c.getClass().getPackage().getName() + c.getClass().getName());
	}
}