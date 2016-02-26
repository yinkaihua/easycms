package com.coding17.easycms.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.web.util.WebConst;

/**
 * 系统初始化
 * @Title: InitializeListener
 * @Package: com.coding17.easycms.web.listener
 * @author: yin.kh
 * @date: 2016年2月3日 下午5:19:42
 */
public class InitializeListener implements ServletContextListener {

	private static final Logger LOG = LoggerFactory.getLogger(InitializeListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//初始化字典缓存
		DictContainer.refresh();
		WebConst.wc_webapp_root_path = arg0.getServletContext().getRealPath("/");
		WebConst.wc_webapp_root_path = "c:\\";
		LOG.info("=====>系统初始化， webapp物理路径：{}", WebConst.wc_webapp_root_path);
	}

}
