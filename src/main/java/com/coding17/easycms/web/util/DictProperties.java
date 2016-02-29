package com.coding17.easycms.web.util;

import com.coding17.easycms.api.container.DictContainer;

/**
 * 字典工具类 
 * @Title: DictUtil.java
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年2月22日 下午9:43:38
 */
public class DictProperties {
	
	/**
	 * 获取有效状态
	 * @return
	 */
	public static String getValidState() {
		return DictContainer.getValByKey("state", "valid");
	}
	
	/**
	 * 获取无效状态
	 * @return
	 */
	public static String getInvalidState() {
		return DictContainer.getValByKey("state", "invalid");
	}
	
	/**
	 * 获取json返回值成功状态
	 * @return
	 */
	public static String getSuccessJsonState() {
		return DictContainer.getValByKey("jsonstate", "success");
	}
	
	/**
	 * 获取json返回值失败状态
	 * @return
	 */
	public static String getFailJsonState() {
		return DictContainer.getValByKey("jsonstate", "fail");
	}
	
	/**
	 * 已生成静态页状态
	 * @return
	 */
	public static String getAlreadyPubState() {
		return DictContainer.getValByKey("pubstate", "yes");
	}
	
	/**
	 * 未生成静态页状态
	 * @return
	 */
	public static String getNoPubState() {
		return DictContainer.getValByKey("pubstate", "no");
	}
}
