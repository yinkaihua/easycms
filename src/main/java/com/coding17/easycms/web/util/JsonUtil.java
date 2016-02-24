package com.coding17.easycms.web.util;

import java.util.HashMap;
import java.util.Map;

/**
 * json工具类 
 * @Title: JsonUtil.java
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年2月24日 下午9:30:51
 */
public class JsonUtil {

	private static final String state = "state";
	
	private static final String data = "data";
	
	private static final String msg = "msg";
	
	public static Map<String, Object> getJsonResult(String state, Object data, String msg) {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put(JsonUtil.state, state);
		json.put(JsonUtil.data, data);
		json.put(JsonUtil.msg, msg);
		return json;
	}
	
	public static Map<String, Object> getFailJsonResult(String msg) {
		return getJsonResult(DictProperties.getFailJsonState(), "", msg);
	}
	
	public static Map<String, Object> getSuccJsonResult(Object data) {
		return getJsonResult(DictProperties.getSuccessJsonState(), data, "");
	}
	
}
