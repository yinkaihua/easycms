package com.coding17.easycms.web.vo.channelcontent;

import com.coding17.easycms.web.base.BaseVo;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class Channelcontent extends BaseVo {
	private static final long serialVersionUID = 1L;
	
	/**
	 *栏目ID
	 */
	private Integer channelId;
	/**
	 *文章ID
	 */
	private Integer contentId;
	
	/**
	 *获取栏目ID
	 */
	public Integer getChannelId(){
		return this.channelId;
	}
	
	/**
	 *设置栏目ID
	 */
	public void setChannelId(Integer channelId){
		this.channelId = channelId;
	}
	
	/**
	 *获取文章ID
	 */
	public Integer getContentId(){
		return this.contentId;
	}
	
	/**
	 *设置文章ID
	 */
	public void setContentId(Integer contentId){
		this.contentId = contentId;
	}
	
    
    /**
     * 重写toString()
     */
	@Override
    public String toString() {
    	StringBuffer tos = new StringBuffer("TChannelContent[");
    	tos.append("channelId=").append(this.channelId).append(",");
    	tos.append("contentId=").append(this.contentId).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

