package com.coding17.easycms.web.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * Vo工具类
 * @Title: BeanConverter
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年2月17日 下午2:32:21
 */
public class BeanConverter {

	/**
	 * 对象转换
	 * @param eo
	 * @param clazz
	 * @return
	 */
	public static <E, T> T objectC(E e, Class<T> clazz) {
		try {
			T t = clazz.newInstance();
			BeanUtils.copyProperties(e, t);
			return t;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * 列表转换
	 * @param elist
	 * @param clazz
	 * @return
	 */
	public static <E, T> List<T> listC(List<E> elist, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		if (elist.size()>0) {
			try {
				for (E e : elist) {
					T t = clazz.newInstance();
					BeanUtils.copyProperties(e, t);
					list.add(t);
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		return list;
	}
	
}
