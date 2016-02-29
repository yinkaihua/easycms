package com.coding17.easycms.web.util;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * velocity工具类
 * @Title: VelocityUtil
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年2月26日 上午9:50:38
 */
public class VelocityUtil {
	
	private static final String ENCODING = "utf-8";
	
	private static final Logger LOG = LoggerFactory.getLogger(VelocityUtil.class);
	
	private static VelocityEngine ve = null;
	
	static {
		Properties prop = new Properties();
		try {
			prop.load(VelocityUtil.class.getResourceAsStream("/velocity.properties"));
			ve = new VelocityEngine(prop);
		} catch (Exception ex) {
			LOG.error("=====>加载velocity配置文件失败", ex);
		}
	}
	
	public static String genHtml(Map<String, Object> params, String templateName) {
		Template template = ve.getTemplate(templateName, ENCODING);
		VelocityContext context = new VelocityContext(params);
		StringWriter out = new StringWriter();
		template.merge(context, out);
		return out.toString();
	}
	
}
