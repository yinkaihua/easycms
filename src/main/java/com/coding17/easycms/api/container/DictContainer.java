package com.coding17.easycms.api.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.coding17.easycms.api.util.SpringBeanUtil;
import com.coding17.easycms.soa.entity.dict.TDict;
import com.coding17.easycms.soa.service.dict.TDictService;
import com.coding17.easycms.web.vo.dict.Dict;

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
	
	private static Map<String, List<Dict>> dict = new HashMap<String, List<Dict>>();
	
	private static void init() {
		long now = System.currentTimeMillis();
		if (tDictService == null) {
			tDictService = SpringBeanUtil.getBean("tDictService", TDictService.class);
		}
		LOG.info("==============>字典Container初始化");
		Map<String, List<Dict>> dictTmp = new HashMap<String, List<Dict>>();
		try {
			TDict param = new TDict();
			List<TDict> list = tDictService.selectListByCondition(param);
			for (TDict td : list) {
//				Map<String, String> entry = null;
				List<Dict> dictList = null;
				dictList = dictTmp.get(td.getCatalogCode());
				if (dictList == null) {
					dictList = new ArrayList<Dict>();
				}
				Dict d = new Dict();
				BeanUtils.copyProperties(td, d);
				dictList.add(d);
				dictTmp.put(d.getCatalogCode(), dictList);
			}
			dict = dictTmp;
			LOG.info("==============>字典Container初始化成功，用时：{}，dict：{}", (System.currentTimeMillis() - now), dict);
		} catch (Exception ex) {
			LOG.error("==============>字典Container初始化失败", ex);
		}
	}
	
	public static void refresh() {
		init();
	}
	
	/**
	 * 查询字典静态方法
	 * @param catalog
	 * @param code
	 * @return
	 */
	public static String getValByKey(String catalog, String key) {
		List<Dict> list = dict.get(catalog);
		if (list != null) {
			for (Dict d : list) {
				if (d.getKey().equals(key)) {
					return d.getValue();
				}
			}
		}
		return null;
	}
	
	/**
	 * 根据Key查询Dict
	 * @param catalog
	 * @param key
	 * @return
	 */
	public static Dict getDictByKey(String catalog, String key) {
		List<Dict> list = dict.get(catalog);
		if (list != null) {
			for (Dict d : list) {
				if (d.getKey().equals(key)) {
					return d;
				}
			}
		}
		return null;
	}
	
	/**
	 * 根据val查询Dict
	 * @param catalog
	 * @param val
	 * @return
	 */
	public static Dict getDictByVal(String catalog, String val) {
		List<Dict> list = dict.get(catalog);
		if (list != null) {
			for (Dict d : list) {
				if (d.getValue().equals(val)) {
					return d;
				}
			}
		}
		return null;
	}
	
	/**
	 * 状态内部类
	 * @Title: State
	 * @Package: com.coding17.easycms.api.container
	 * @author: yin.kh
	 * @date: 2016年2月15日 下午4:12:24
	 */
	public static class State {
		public static Integer getValidState() {
			return Integer.parseInt(DictContainer.getDictByKey("state", "valid").getValue());
		}
	}
	
}
