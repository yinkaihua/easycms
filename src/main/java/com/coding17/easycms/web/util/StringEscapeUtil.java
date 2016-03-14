package com.coding17.easycms.web.util;

/**
 * 字符串转义方法
 * @Title: StringEscapeUtil.java
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年3月14日 下午7:36:08
 */
public class StringEscapeUtil {

	/**
	 * 简单的<>替换
	 * @param txt
	 * @return
	 */
	public static String escapeHtml(String txt) {
		return txt.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
	
}
