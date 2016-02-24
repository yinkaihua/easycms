package com.coding17.easycms.web.vo.menu;

import java.util.List;

import com.coding17.easycms.web.base.BaseVo;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class Menu extends BaseVo {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 */
	private Integer id;
	/**
	 *父菜单，0表示顶级菜单
	 */
	private Integer pid;
	/**
	 *菜单级别
	 */
	private Integer level;
	/**
	 *菜单名
	 */
	private String text;
	/**
	 *菜单链接，0表示无链接
	 */
	private String action;
	/**
	 *排序字段
	 */
	private Integer sort;
	/**
	 *状态，1：正常，9：删除
	 */
	private Integer state;
	
	private List<Menu> subMenus;
	
	public List<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	/**
	 *获取
	 */
	public Integer getId(){
		return this.id;
	}
	
	/**
	 *设置
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 *获取父菜单，0表示顶级菜单
	 */
	public Integer getPid(){
		return this.pid;
	}
	
	/**
	 *设置父菜单，0表示顶级菜单
	 */
	public void setPid(Integer pid){
		this.pid = pid;
	}
	
	/**
	 *获取菜单级别
	 */
	public Integer getLevel(){
		return this.level;
	}
	
	/**
	 *设置菜单级别
	 */
	public void setLevel(Integer level){
		this.level = level;
	}
	
	/**
	 *获取菜单名
	 */
	public String getText(){
		return this.text;
	}
	
	/**
	 *设置菜单名
	 */
	public void setText(String text){
		this.text = text;
	}
	
	/**
	 *获取菜单链接，0表示无链接
	 */
	public String getAction(){
		return this.action;
	}
	
	/**
	 *设置菜单链接，0表示无链接
	 */
	public void setAction(String action){
		this.action = action;
	}
	
	/**
	 *获取排序字段
	 */
	public Integer getSort(){
		return this.sort;
	}
	
	/**
	 *设置排序字段
	 */
	public void setSort(Integer sort){
		this.sort = sort;
	}
	
	/**
	 *获取状态，1：正常，9：删除
	 */
	public Integer getState(){
		return this.state;
	}
	
	/**
	 *设置状态，1：正常，9：删除
	 */
	public void setState(Integer state){
		this.state = state;
	}
	
    
    /**
     * 重写toString()
     */
	@Override
    public String toString() {
    	StringBuffer tos = new StringBuffer("Menu[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("pid=").append(this.pid).append(",");
    	tos.append("level=").append(this.level).append(",");
    	tos.append("text=").append(this.text).append(",");
    	tos.append("action=").append(this.action).append(",");
    	tos.append("sort=").append(this.sort).append(",");
    	tos.append("state=").append(this.state).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

