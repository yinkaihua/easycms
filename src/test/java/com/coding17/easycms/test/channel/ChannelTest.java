package com.coding17.easycms.test.channel;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coding17.easycms.soa.dao.channel.TChannelDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;

public class ChannelTest {

	private BeanFactory factory;
	
	private TChannelDAO dao;
	
	@Before
	public void before() {
		factory = new ClassPathXmlApplicationContext("spring-conf.xml");
		dao = (TChannelDAO) factory.getBean("tChannelDAO");
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
		dao.insert(c);
	}
	
}
