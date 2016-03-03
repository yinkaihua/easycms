package com.coding17.easycms.soa.dao.content;

import java.util.List;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.entity.content.TContent;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public interface TContentDAO extends ISuperDAO<TContent> {

	/**
	 * 关联查询，内容，栏目
	 * @param tContent
	 * @return
	 */
	public List<TContent> selectListInfoByPagination(TContent tContent);
	
	/**
	 * 关联查询数量，用于分页
	 * @param tContent
	 * @return
	 */
	public Integer selectListInfoCountByCondition(TContent tContent);
	
	/**
	 * 关联查询，主键
	 * @param tContent
	 * @return
	 */
	public TContent findInfoByPriKey(TContent tContent);
	
	/**
	 * 查询当前记录上一条
	 * @param tContent
	 * @return
	 */
	public TContent selectOneInfoPre(TContent tContent);
	
	/**
	 * 查询当前记录下一条
	 * @param tContent
	 * @return
	 */
	public TContent selectOneInfoNext(TContent tContent);
	
}