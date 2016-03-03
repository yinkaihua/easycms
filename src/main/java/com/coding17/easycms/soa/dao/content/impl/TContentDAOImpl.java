package com.coding17.easycms.soa.dao.content.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.impl.SuperDAO;
import com.coding17.easycms.soa.dao.content.TContentDAO;
import com.coding17.easycms.soa.entity.content.TContent;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tContentDAO")
public class TContentDAOImpl extends SuperDAO<TContent> implements TContentDAO {

	@Override
	protected String getStatementPrefix() {
		return TContent.class.getName();
	}

	@Override
	public List<TContent> selectListInfoByPagination(TContent tContent) {
		return selectListByPagination(getStatementPrefix() + ".selectListInfoByPagination", tContent);
	}

	@Override
	public Integer selectListInfoCountByCondition(TContent tContent) {
		return selectCountByCondition(getStatementPrefix() + ".selectListInfoByPagination-count", tContent);
	}

	@Override
	public TContent findInfoByPriKey(TContent tContent) {
		return getTemplate().selectOne(getStatementPrefix() + ".findInfoByPriKey", tContent);
	}

	@Override
	public TContent selectOneInfoPre(TContent tContent) {
		return getTemplate().selectOne(getStatementPrefix() + ".selectOneInfoPre", tContent);
	}

	@Override
	public TContent selectOneInfoNext(TContent tContent) {
		return getTemplate().selectOne(getStatementPrefix() + ".selectOneInfoNext", tContent);
	}

}