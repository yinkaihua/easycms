package com.coding17.easycms.soa.service.content;

import java.util.List;

import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.base.service.BaseService;
import com.coding17.easycms.soa.entity.content.TContent;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public interface TContentService extends BaseService<TContent> {
	
	/**
	 * 关联查询，内容，栏目，分页
	 * @param tContent
	 * @return
	 */
	public Pagination<TContent> selectListInfoByPagination(TContent tContent);
	
}