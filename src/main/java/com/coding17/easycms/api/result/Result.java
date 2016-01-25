package com.coding17.easycms.api.result;

/**
 * 服务返回结果封闭类
 * @Title: Result.java
 * @Package: com.coding17.easycms.api.base
 * @author: yin.kh
 * @date: 2016年1月25日 下午11:58:42
 */
public class Result<T> {

	private String resultCode;
	
	private T t;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
