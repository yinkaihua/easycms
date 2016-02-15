package com.coding17.easycms.soa.entity.site;

import java.util.Date;
import com.coding17.easycms.soa.base.entity.BasicEntity;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class TSite extends BasicEntity {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 */
	private Integer id;
	/**
	 *访问域名
	 */
	private String domain;
	/**
	 *站点名称
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
	 *创建人ID
	 */
	private Integer account;
	/**
	 *创建人姓名
	 */
	private String accountName;
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
	 *获取访问域名
	 */
	public String getDomain(){
		return this.domain;
	}
	
	/**
	 *设置访问域名
	 */
	public void setDomain(String domain){
		this.domain = domain;
	}
	
	/**
	 *获取站点名称
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 *设置站点名称
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
	 *获取创建人ID
	 */
	public Integer getAccount(){
		return this.account;
	}
	
	/**
	 *设置创建人ID
	 */
	public void setAccount(Integer account){
		this.account = account;
	}
	
	/**
	 *获取创建人姓名
	 */
	public String getAccountName(){
		return this.accountName;
	}
	
	/**
	 *设置创建人姓名
	 */
	public void setAccountName(String accountName){
		this.accountName = accountName;
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
    	StringBuffer tos = new StringBuffer("TSite[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("domain=").append(this.domain).append(",");
    	tos.append("name=").append(this.name).append(",");
    	tos.append("path=").append(this.path).append(",");
    	tos.append("createTime=").append(this.createTime).append(",");
    	tos.append("account=").append(this.account).append(",");
    	tos.append("accountName=").append(this.accountName).append(",");
    	tos.append("state=").append(this.state).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

