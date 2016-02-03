package com.coding17.easycms.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.coding17.easycms.api.container.DictContainer;

/**
 * 系统初始化
 * @Title: InitializeListener
 * @Package: com.coding17.easycms.web.listener
 * @author: yin.kh
 * @date: 2016年2月3日 下午5:19:42
 */
public class InitializeListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//初始化字典缓存
		DictContainer.refresh();
	}

}
