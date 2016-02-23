package com.coding17.easycms.web.vo.contentext;

import com.coding17.easycms.web.base.BaseVo;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class Contentext extends BaseVo {
	private static final long serialVersionUID = 1L;
	
	/**
	 *文章ID
	 */
	private Integer contentId;
	/**
	 *文章内容
	 */
	private String txt;
	
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
	 *获取文章内容
	 */
	public String getTxt(){
		return this.txt;
	}
	
	/**
	 *设置文章内容
	 */
	public void setTxt(String txt){
		this.txt = txt;
	}
	
    
    /**
     * 重写toString()
     */
	@Override
    public String toString() {
    	StringBuffer tos = new StringBuffer("TContentExt[");
    	tos.append("contentId=").append(this.contentId).append(",");
    	tos.append("txt=").append(this.txt).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

