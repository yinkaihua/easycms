package com.coding17.easycms.web.vo.dict;

import com.coding17.easycms.web.base.BaseVo;

/**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
public class Dict extends BaseVo {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 */
	private Integer id;
	/**
	 *分类code
	 */
	private String catalogCode;
	/**
	 *键
	 */
	private String key;
	/**
	 *值
	 */
	private String value;
	/**
	 *描述
	 */
	private String desc;
	
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
	 *获取分类code
	 */
	public String getCatalogCode(){
		return this.catalogCode;
	}
	
	/**
	 *设置分类code
	 */
	public void setCatalogCode(String catalogCode){
		this.catalogCode = catalogCode;
	}
	
	/**
	 *获取键
	 */
	public String getKey(){
		return this.key;
	}
	
	/**
	 *设置键
	 */
	public void setKey(String key){
		this.key = key;
	}
	
	/**
	 *获取值
	 */
	public String getValue(){
		return this.value;
	}
	
	/**
	 *设置值
	 */
	public void setValue(String value){
		this.value = value;
	}
	
	/**
	 *获取描述
	 */
	public String getDesc(){
		return this.desc;
	}
	
	/**
	 *设置描述
	 */
	public void setDesc(String desc){
		this.desc = desc;
	}
	
    
    /**
     * 重写toString()
     */
	@Override
    public String toString() {
    	StringBuffer tos = new StringBuffer("TDict[");
    	tos.append("id=").append(this.id).append(",");
    	tos.append("catalogCode=").append(this.catalogCode).append(",");
    	tos.append("key=").append(this.key).append(",");
    	tos.append("value=").append(this.value).append(",");
    	tos.append("desc=").append(this.desc).append(",");
    	tos.append("]");
        return tos.toString();
    }
    
}

