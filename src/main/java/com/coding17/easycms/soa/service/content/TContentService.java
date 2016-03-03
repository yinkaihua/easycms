package com.coding17.easycms.soa.service.content;

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
	
	/**
	 * 发布文章
	 * @param content
	 * @return
	 */
	public TContent createContent(TContent content);
	
	/**
	 * 更新文章
	 * @param content
	 * @return
	 */
	public TContent updateContent(TContent content);
	
	/**
	 * 删除文章
	 * @param content
	 * @return
	 */
	public TContent deleteContent(TContent content);
	
	/**
	 * 关联查询，ID
	 * @param content
	 * @return
	 */
	public TContent getInfoByPriKey(TContent content);
	
	/**
	 * 查询当前记录上一条
	 * @param content
	 * @return
	 */
	public TContent selectOneInfoPre(TContent content);
	
	/**
	 * 查询当前记录下一条
	 * @param content
	 * @return
	 */
	public TContent selectOneInfoNext(TContent content);
	
}