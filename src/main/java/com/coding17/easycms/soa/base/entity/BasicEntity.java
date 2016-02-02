package com.coding17.easycms.soa.base.entity;

import java.io.Serializable;

/**
 * 全部实体的基类，提供分页查询等
 * @Title: BasicEntity.java 
 * @Package: com.coding17.easycms.soa.base.entity  
 * @author: yin.kh
 * @date: 2016年1月23日 下午10:24:29
 */
public class BasicEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pageNum;
	
	private Integer pageSize;
	
	private Integer offset;
	
	private String orderby;

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

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

}
