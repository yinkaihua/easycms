package com.coding17.easycms.web.base;

import java.io.Serializable;

/**
 * vo基础类
 * @Title: BaseVo
 * @Package: com.coding17.easycms.web.base
 * @author: yin.kh
 * @date: 2016年2月3日 上午11:30:04
 */
public class BaseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pageNum;
	
	private Integer pageSize;
	
	private Integer offset;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
}
