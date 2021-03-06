package com.coding17.easycms.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.web.vo.dict.Dict;

/**
 * 自定义字典标签
 * @Title: DictTag
 * @Package: com.coding17.easycms.web.tag
 * @author: yin.kh
 * @date: 2016年2月15日 下午4:08:54
 */
public class DictTag extends SimpleTagSupport {

	private String catalog;
	
	private String code;
	
	@Override
	public void doTag() throws JspException, IOException {
		Dict dict = DictContainer.getDictByVal(catalog, code);
		if (dict==null) {
			throw new NullPointerException("字典表查询不到");
		}
		getJspContext().getOut().println(dict.getDesc());
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
