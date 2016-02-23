package com.coding17.easycms.soa.entity.content;

import java.util.Date;
import com.coding17.easycms.soa.base.entity.BasicEntity;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.entity.channelcontent.TChannelContent;
import com.coding17.easycms.soa.entity.contentext.TContentExt;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class TContent extends BasicEntity {
	private static final long serialVersionUID = 1L;
	
	/**
	 *文章ID
	 */
	private Integer id;
	/**
	 *标题
	 */
	private String title;
	/**
	 *创建时间
	 */
	private Date createTime;
	/**
	 *发布状态 1：发布；2：未发布
	 */
	private Integer pubState;
	/**
	 *状态；1：正常，9：删除
	 */
	private Integer state;

	private TContentExt contentExt;
	
	private TChannel channel;
	
	public TContentExt getContentExt() {
		return contentExt;
	}

	public void setContentExt(TContentExt contentExt) {
		this.contentExt = contentExt;
	}

	public TChannel getChannel() {
		return channel;
	}

	public void setChannel(TChannel channel) {
		this.channel = channel;
	}

	/**
	 *获取文章ID
	 */
	public Integer getId(){
		return this.id;
	}
	
	/**
	 *设置文章ID
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 *获取标题
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 *设置标题
	 */
	public void setTitle(String title){
		this.title = title;
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
	 *获取发布状态 1：发布；2：未发布
	 */
	public Integer getPubState(){
		return this.pubState;
	}
	
	/**
	 *设置发布状态 1：发布；2：未发布
	 */
	public void setPubState(Integer pubState){
		this.pubState = pubState;
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
    	StringBuffer tos = new StringBuffer("TContent[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("title=").append(this.title).append(",");
    	tos.append("createTime=").append(this.createTime).append(",");
    	tos.append("pubState=").append(this.pubState).append(",");
    	tos.append("state=").append(this.state).append(",");
    	tos.append("contentExt=").append(this.contentExt).append(",");
    	tos.append("channel=").append(this.channel).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

