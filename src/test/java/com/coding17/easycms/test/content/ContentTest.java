package com.coding17.easycms.test.content;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.dao.content.TContentDAO;
import com.coding17.easycms.soa.entity.channel.TChannel;
import com.coding17.easycms.soa.entity.content.TContent;
import com.coding17.easycms.soa.entity.contentext.TContentExt;
import com.coding17.easycms.soa.service.content.TContentService;

public class ContentTest {

private BeanFactory factory;
	
	private TContentDAO dao;
	
	private TContentService service;
	
	@Before
	public void before() {
		factory = new ClassPathXmlApplicationContext("spring-conf.xml");
		dao = (TContentDAO) factory.getBean("tContentDAO");
		service = (TContentService) factory.getBean("tContentService");
	}
	
	@After
	public void after() {
		
	}
	
	@Test
	public void selectListInfoByCondition() {
		TContent para = new TContent();
		TChannel channel = new TChannel();
		channel.setSiteId(7);
		para.setChannel(channel);
		para.setPageNum(1);
		para.setPageSize(5);
		List<TContent> list = dao.selectListInfoByPagination(para);
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void selectListInfoCountByCondition() {
		TContent para = new TContent();
		TChannel channel = new TChannel();
		channel.setSiteId(7);
		para.setChannel(channel);
		int r = dao.selectListInfoCountByCondition(para);
		Assert.assertTrue(r>0);
	}
	
	@Test
	public void selectListInfoByPagination() {
		TContent para = new TContent();
		TChannel channel = new TChannel();
		channel.setSiteId(7);
		para.setChannel(channel);
		para.setPageNum(1);
		para.setPageSize(5);
		Pagination<TContent> pager = service.selectListInfoByPagination(para);
		System.out.println("=====================" + pager);
	}
	
	@Test
	public void createTx() {
		TContent c = new TContent();
		c.setTitle("aaaa");
		c.setCreateTime(new Date());
		TContentExt e = new TContentExt();
		e.setTxt("ljkdsflsdjfklsdfkjsldkjf");
		TChannel ch = new TChannel();
		ch.setId(2);
		c.setContentExt(e);
		c.setChannel(ch);
		try {
			service.createContent(c);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
