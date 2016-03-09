package com.coding17.easycms.test.utils;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

public class StringEscapeUtil {

	@Test
	public void htmlEscape() {
		String s = StringEscapeUtils.escapeHtml("<!-->");
		System.out.println(s);
	}
	
}
