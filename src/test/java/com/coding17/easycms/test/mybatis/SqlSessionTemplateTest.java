package com.coding17.easycms.test.mybatis;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coding17.easycms.soa.entity.channel.TChannel;

public class SqlSessionTemplateTest {

	private BeanFactory factory;
	
	private SqlSessionTemplate template;
	
	@Before
	public void before() {
		factory = new ClassPathXmlApplicationContext("spring-mybatis-test.xml");
		template = (SqlSessionTemplate) factory.getBean("sqlSessionTemplate");
	}
	
	@After
	public void after() {
		
	}
	
	@Test
	public void create() {
		TChannel c = new TChannel();
		c.setName("书记");
		c.setPath("/sj");
		c.setCreateTime(new Date());
		template.insert("TChannelMapper.insert", c);
	}
	
}
