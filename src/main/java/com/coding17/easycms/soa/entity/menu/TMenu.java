package com.coding17.easycms.soa.entity.menu;

import com.coding17.easycms.soa.base.entity.BasicEntity;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class TMenu extends BasicEntity {
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
    	StringBuffer tos = new StringBuffer("TMenu[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("pid=").append(this.pid).append(",");
    	tos.append("text=").append(this.text).append(",");
    	tos.append("action=").append(this.action).append(",");
    	tos.append("sort=").append(this.sort).append(",");
    	tos.append("state=").append(this.state).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

