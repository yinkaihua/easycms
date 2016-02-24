package com.coding17.easycms.web.vo.tree;

import java.util.List;
import java.util.Map;

/**
 * 树形结点
 * @Title: TreeNode
 * @Package: com.coding17.easycms.web.vo.tree
 * @author: yin.kh
 * @date: 2016年2月24日 下午5:15:14
 */
public class TreeNode {

	private Integer id;
	
	private String text;
	
	private String iconCls;
	
	private String state;
	
	private boolean checked;
	
	private Map<String, Object> attributes;
	
	private List<TreeNode> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		StringBuffer tos = new StringBuffer("TreeNode[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("text=").append(this.text).append(",");
    	tos.append("iconCls=").append(this.iconCls).append(",");
    	tos.append("state=").append(this.state).append(",");
    	tos.append("checked=").append(this.checked).append(",");
    	tos.append("attributes=").append(this.attributes).append(",");
    	tos.append("children=").append(this.children).append(",");
    	tos.append("]");
        return tos.toString();
	}
	
}
