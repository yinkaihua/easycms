package com.coding17.easycms.web.vo.channel;

import java.util.Date;
import com.coding17.easycms.web.base.BaseVo;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class Channel extends BaseVo {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 */
	private Integer id;
	/**
	 *父栏目ID，为0表示顶级栏目
	 */
	private Integer pid;
	/**
	 *站点ID
	 */
	private Integer siteId;
	/**
	 *显示名称
	 */
	private String name;
	/**
	 *访问路径
	 */
	private String path;
	/**
	 *创建时间
	 */
	private Date createTime;
	/**
	 *排序
	 */
	private Integer sort;
	/**
	 *状态；1：正常，9：删除
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
	 *获取父栏目ID，为0表示顶级栏目
	 */
	public Integer getPid(){
		return this.pid;
	}
	
	/**
	 *设置父栏目ID，为0表示顶级栏目
	 */
	public void setPid(Integer pid){
		this.pid = pid;
	}
	
	/**
	 *获取站点ID
	 */
	public Integer getSiteId(){
		return this.siteId;
	}
	
	/**
	 *设置站点ID
	 */
	public void setSiteId(Integer siteId){
		this.siteId = siteId;
	}
	
	/**
	 *获取显示名称
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 *设置显示名称
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 *获取访问路径
	 */
	public String getPath(){
		return this.path;
	}
	
	/**
	 *设置访问路径
	 */
	public void setPath(String path){
		this.path = path;
	}
	
	/**
	 *获取创建时间
	 */
	public Date getCreateTime(){
		return this.createTime;
	}
	
	/**
	 *设置创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	/**
	 *获取排序
	 */
	public Integer getSort(){
		return this.sort;
	}
	
	/**
	 *设置排序
	 */
	public void setSort(Integer sort){
		this.sort = sort;
	}
	
	/**
	 *获取状态；1：正常，9：删除
	 */
	public Integer getState(){
		return this.state;
	}
	
	/**
	 *设置状态；1：正常，9：删除
	 */
	public void setState(Integer state){
		this.state = state;
	}
	
    
    /**
     * 重写toString()
     */
	@Override
    public String toString() {
    	StringBuffer tos = new StringBuffer("TChannel[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("pid=").append(this.pid).append(",");
    	tos.append("siteId=").append(this.siteId).append(",");
    	tos.append("name=").append(this.name).append(",");
    	tos.append("path=").append(this.path).append(",");
    	tos.append("createTime=").append(this.createTime).append(",");
    	tos.append("sort=").append(this.sort).append(",");
    	tos.append("state=").append(this.state).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

