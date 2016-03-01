package com.coding17.easycms.test.channel;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.dao.channel.TChannelDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.service.channel.TChannelService;

public class ChannelTest {

	private BeanFactory factory;
	
	private TChannelDAO dao;
	
	private TChannelService tChannelService;
	
	@Before
	public void before() {
		factory = new ClassPathXmlApplicationContext("spring-conf.xml");
		dao = (TChannelDAO) factory.getBean("tChannelDAO");
		tChannelService = (TChannelService) factory.getBean("tChannelService");
	}
	
	@After
	public void after() {
		
	}
	
	@Test
	public void create() {
		TChannel c = new TChannel();
		c.setName("书记");
		c.setPath("/sj");
		c.setPid(0);
		c.setSiteId(0);
		c.setCreateTime(new Date());
//		dao.insert(c);
		tChannelService.create(c);
	}
	
	@Test
	public void selectCount() {
		TChannel c = new TChannel();
		//c.setId(1);
		System.out.println(tChannelService.selectCountByCondition(c));
	}
	
	@Test
	public void selectByPriKey() {
		TChannel c = new TChannel();
		c.setId(2);
		System.out.println(tChannelService.getByPriKey(c));
	}
	
	@Test
	public void selectInfoPagination() {
		TChannel c = new TChannel();
		c.setId(11);
		c.setOrderby("h.`SORT` asc, c.`ID` asc");
		Pagination<TChannel> page = tChannelService.selectListInfoByPagination(c);
		System.out.println(page);
	}
	
}
