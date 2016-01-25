package com.coding17.easycms.tool;

import java.lang.reflect.Field;

import com.coding17.easycms.soa.entity.channel.TChannel;

public class CodeTool {
	/**
	 *
	 * @Title: CodeTool.java 
	 * @Package: com.coding17.easycms.tool  
	 * @author: yin.kh
	 * @date: 2016年1月25日 下午11:29:30 
	 */
	
	public static <T> void tos(Class<T> clazz) {
		Field[] fs = clazz.getDeclaredFields();
		String s = "\"" + clazz.getName()+"[";
		for (Field f : fs) {
			String n = f.getName();
			s += n + "=\"+this." + n + "+\",";
		}
		s = s.substring(0, s.length()-2);
		s += "\"]\"";
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		tos(TChannel.class);
	}
}
