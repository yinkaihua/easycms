package com.coding17.easycms.api.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * SpringBean 工具类
 * @Title: SpringBeanUtil
 * @Package: com.coding17.easycms.api.util
 * @author: yin.kh
 * @date: 2016年2月3日 下午4:00:36
 */
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationContext = arg0;
	}
	
	/**
	 * 获取bean
	 * @param bean
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(String bean, Class<T> clazz) {
		return applicationContext.getBean(bean, clazz);
	}

}
