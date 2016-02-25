package com.coding17.easycms.soa.exception;

/**
 * 服务端异常
 * @Title: CmsSoaExcpetion
 * @Package: com.coding17.easycms.soa.exception
 * @author: yin.kh
 * @date: 2016年2月25日 下午8:01:04
 */
public class CmsSoaExcpetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmsSoaExcpetion(String msg) {
		super(msg);
	}
	
	public CmsSoaExcpetion(Throwable e) {
		super(e);
	}
	
}
