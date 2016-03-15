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
	 * 默认页码
	 */
	public static final Integer DEFAULT_PAGENUM = 1;
	
	/**
	 * 默认每页数量
	 */
	public static final Integer DEFAULT_PAGESIZE = 10;
	
	/**
	 * 每页数量最大值
	 */
	public static final Integer MAX_PAGESIZE = 100;
	
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

	public Pagination() {}
	
	public Pagination(int pageNum, int pageSize, int totalCount, int totalPage, List<T> datas) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.datas = datas;
	}
	
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
	
	@Override
	public String toString() {
		StringBuffer tos = new StringBuffer("Pagination[");
		tos.append("pageNum=").append(this.pageNum).append(",");
		tos.append("pageSize=").append(this.pageSize).append(",");
		tos.append("totalCount=").append(this.totalCount).append(",");
		tos.append("totalPage=").append(this.totalPage).append(",");
		tos.append("datas=[");
		if (datas!=null && datas.size()>0) {
			for (int i = 0; i < datas.size(); i++) {
				T t = datas.get(i);
				tos.append(t).append(",");
			}
		}
		tos.append("]]");
		return tos.toString();
	}
}
