package com.coding17.easycms.web.vo.content;

import java.util.Date;

import com.coding17.easycms.soa.entity.content.TContent;
import com.coding17.easycms.web.base.BaseVo;
import com.coding17.easycms.web.util.BeanConverter;
import com.coding17.easycms.web.vo.channel.Channel;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class Content extends BaseVo {
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
	 *SEO标题
	 */
	private String metaTitle;
	/**
	 *SEO关键字
	 */
	private String metaKeywords;
	/**
	 *SEO描述
	 */
	private String metaDescription;
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
	
	private ContentExt contentExt;
	
	private Channel channel;
	
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
	 *获取SEO标题
	 */
	public String getMetaTitle(){
		return this.metaTitle;
	}
	
	/**
	 *设置SEO标题
	 */
	public void setMetaTitle(String metaTitle){
		this.metaTitle = metaTitle;
	}
	
	/**
	 *获取SEO关键字
	 */
	public String getMetaKeywords(){
		return this.metaKeywords;
	}
	
	/**
	 *设置SEO关键字
	 */
	public void setMetaKeywords(String metaKeywords){
		this.metaKeywords = metaKeywords;
	}
	
	/**
	 *获取SEO描述
	 */
	public String getMetaDescription(){
		return this.metaDescription;
	}
	
	/**
	 *设置SEO描述
	 */
	public void setMetaDescription(String metaDescription){
		this.metaDescription = metaDescription;
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
    
    public ContentExt getContentExt() {
		return contentExt;
	}

	public void setContentExt(ContentExt contentExt) {
		this.contentExt = contentExt;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	/**
     * 重写toString()
     */
	@Override
    public String toString() {
    	StringBuffer tos = new StringBuffer("Content[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("title=").append(this.title).append(",");
    	tos.append("metaTitle=").append(this.metaTitle).append(",");
    	tos.append("metaKeywords=").append(this.metaKeywords).append(",");
    	tos.append("metaDescription=").append(this.metaDescription).append(",");
    	tos.append("createTime=").append(this.createTime).append(",");
    	tos.append("pubState=").append(this.pubState).append(",");
    	tos.append("state=").append(this.state).append(",");
    	tos.append("contentExt=").append(this.contentExt).append(",");
    	tos.append("channel=").append(this.channel).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
	public static Content fromEntity(TContent entity) {
		Content vo = BeanConverter.objectC(entity, Content.class);
		if (entity.getChannel()!=null) {
			Channel c = BeanConverter.objectC(entity.getChannel(), Channel.class);
			vo.setChannel(c);
		}
		if (entity.getContentExt()!=null) {
			ContentExt e = BeanConverter.objectC(entity.getContentExt(), ContentExt.class);
			vo.setContentExt(e);
		}
		return vo;
	}
	
}

