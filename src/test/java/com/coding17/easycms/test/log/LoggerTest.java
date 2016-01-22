package com.coding17.easycms.test.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	
	@Test
	public void logTest() {
		Logger logger = LoggerFactory.getLogger(LoggerTest.class);
		logger.info("Hello,This is a logger");
	}
	
}
