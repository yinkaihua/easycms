package com.coding17.easycms.web.exception;

/**
 * 异常
 * @Title: CmsWebException
 * @Package: com.coding17.easycms.web.exception
 * @author: yin.kh
 * @date: 2016年2月17日 下午6:03:58
 */
public class CmsWebException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CmsWebException(String msg) {
		super(msg);
	}
	
	public CmsWebException(Throwable e) {
		super(e);
	}

}
