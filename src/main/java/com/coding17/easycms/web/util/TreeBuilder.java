package com.coding17.easycms.web.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.coding17.easycms.web.exception.CmsWebException;
import com.coding17.easycms.web.vo.tree.TreeNode;

/**
 * 构造树形菜单数据结构工具类
 * @Title: TreeBuilder
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年2月24日 下午5:33:54
 */
public class TreeBuilder {

	/**
     * 构造树形菜单
	 * @param list    
	 * @param clazz
	 * @param fields 对应类，[0]id,[1]text,[2]iconCls,[3]state,[4]checked,[5]attributes(逗号分隔多个字段),[6]children
	 * @return
	 */
	public static <T> List<TreeNode> build(List<T> list, Class<T> clazz, String[] fields) {
		checkParam(clazz, fields);
		List<TreeNode> tree = new ArrayList<TreeNode>();
		for (T t : list) {
			tree.add(buildTreeNode(t, clazz, fields));
		}
		return tree;
	}
	
	private static <T> void checkParam(Class<T> clazz, String[] fields) {
		if (clazz == null || fields.length!=7) {
			throw new CmsWebException("构造树形菜单失败，参数无效");
		}
	}
	
	/**
     * 构造树形结果
	 * @param t    
	 * @param clazz
	 * @param fields 对应类，[0]id,[1]text,[2]iconCls,[3]state,[4]checked,[5]attributes(逗号分隔多个字段),[6]children
	 * @return
	 */
	private static <T> TreeNode buildTreeNode(T t, Class<T> clazz, String[] fields) {
		TreeNode node = new TreeNode();
		try {
			if (!StringUtils.isEmpty(fields[0])) {
				node.setId((Integer) getFieldValue(t, clazz, fields[0]));
			}
			if (!StringUtils.isEmpty(fields[1])) {
				node.setText(getFieldValue(t, clazz, fields[1]).toString());
			}
			if (!StringUtils.isEmpty(fields[2])) {
				node.setIconCls(getFieldValue(t, clazz, fields[2]).toString());
			}
			if (!StringUtils.isEmpty(fields[3])) {
				node.setState(getFieldValue(t, clazz, fields[3]).toString());
			}
			if (!StringUtils.isEmpty(fields[4])) {
				node.setChecked(Boolean.valueOf(getFieldValue(t, clazz, fields[4]).toString()));
			}
			if (!StringUtils.isEmpty(fields[5])) {
				String attributeMap = fields[5];
				Map<String, Object> attributes = new HashMap<String, Object>();
				for (String a : attributeMap.split(",")) {
					attributes.put(a, getFieldValue(t, clazz, a).toString());
				}
				node.setAttributes(attributes);
			}
			if (!StringUtils.isEmpty(fields[6])) {
				Object obj = getFieldValue(t, clazz, fields[6]);
				if (obj!=null || !CollectionUtils.isEmpty((List<T>)obj)) {
					node.setChildren(build((List<T>) obj, clazz, fields));
				}
			}
		} catch (Exception e) {
			throw new CmsWebException(e);
		}
		return node;
	}
	
	private static <T> Object getFieldValue(T t, Class<T> clazz, String field) {
		try {
			Field f = clazz.getDeclaredField(field);
			f.setAccessible(true);
			return f.get(t);
		} catch (Exception e) {
			throw new CmsWebException(e);
		}
	}
	
}
