package com.coding17.easycms.soa.base.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口调用 切面
 * @Title: MethodInvodeAspect.java
 * @Package: com.coding17.easycms.soa.base.aop
 * @author: yin.kh
 * @date: 2016年1月26日 下午10:38:29
 */
public class MethodInvokeAspect {

	private static final Logger logger = LoggerFactory.getLogger(MethodInvokeAspect.class);
	
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("================>方法调用START，方法：{}，参数：{}", joinPoint.getTarget(), joinPoint.getArgs());
		long startTime = System.currentTimeMillis();
		Object ret = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("================>方法调用END，方法：{}，结果：{}，耗时：{}", joinPoint.getTarget(), joinPoint.getArgs(), (endTime-startTime));
		return ret;
	}
	
}
