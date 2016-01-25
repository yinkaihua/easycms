package com.coding17.easycms.soa.entity.channel;

import java.util.Date;

import com.coding17.easycms.soa.base.entity.BasicEntity;

/**
 * 栏目实体类
 * 
 * @Title: TChannel.java
 * @Package: com.coding17.easycms.soa.entity.channel
 * @author: yin.kh
 * @date: 2016年1月25日 下午11:28:39
 */
public class TChannel extends BasicEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String path;

	private String name;

	private Integer pid;

	private Date createTime;

	private Byte state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	@Override
    public String toString() {
		return "com.coding17.easycms.soa.entity.channel.TChannel[serialVersionUID=" + this.serialVersionUID + ",id="
				+ this.id + ",path=" + this.path + ",name=" + this.name + ",pid=" + this.pid + ",createTime="
				+ this.createTime + ",state=" + this.state + "]";
    }
}