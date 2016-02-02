package com.coding17.easycms.soa.base.pager;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类
 * @Title: Pagination
 * @Package: com.coding17.easycms.soa.base.pager
 * @author: yin.kh
 * @date: 2016年2月2日 下午5:59:59
 * @param <T>
 */
public class Pagination<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 页码
	 */
	private Integer pageNum;
	
	/**
	 * 每页多少数据
	 */
	private Integer pageSize;
	
	/**
	 * 数据总量
	 */
	private Integer totalCount;
	
	/**
	 * 页码总量
	 */
	private Integer totalPage;
	
	/**
	 * 数据
	 */
	private List<T> datas;

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

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
}
