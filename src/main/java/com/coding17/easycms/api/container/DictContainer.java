package com.coding17.easycms.api.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coding17.easycms.api.util.SpringBeanUtil;
import com.coding17.easycms.soa.entity.dict.TDict;
import com.coding17.easycms.soa.service.dict.TDictService;

/**
 * 字典
 * @Title: DictContainer
 * @Package: com.coding17.easycms.api.container
 * @author: yin.kh
 * @date: 2016年2月3日 下午3:46:34
 */
public class DictContainer {

	private static final Logger LOG = LoggerFactory.getLogger(DictContainer.class);
	
	private static TDictService tDictService = null;
	
	private static Map<String, Map<String, String>> dict = new HashMap<String, Map<String, String>>();
	
	private static void init() {
		long now = System.currentTimeMillis();
		if (tDictService == null) {
			tDictService = SpringBeanUtil.getBean("tDictService", TDictService.class);
		}
		LOG.info("==============>字典Container初始化");
		dict.clear();
		TDict param = new TDict();
		try {
			List<TDict> list = tDictService.selectListByCondition(param);
			for (TDict d : list) {
				Map<String, String> entry = null;
				entry = dict.get(d.getCatalogCode());
				if (entry == null) {
					entry = new HashMap<String, String>();
				}
				entry.put(d.getKey(), d.getValue());
				dict.put(d.getCatalogCode(), entry);
			}
			LOG.info("==============>字典Container初始化成功，用时：{}，dict：{}", (System.currentTimeMillis() - now), dict);
		} catch (Exception ex) {
			LOG.error("==============>字典Container初始化失败", ex);
		}
	}
	
	public static void refresh() {
		init();
	}
	
	public static class State {
		public static Integer getValidState() {
			return Integer.parseInt(dict.get("state").get("valid"));
		}
	}
	
}
