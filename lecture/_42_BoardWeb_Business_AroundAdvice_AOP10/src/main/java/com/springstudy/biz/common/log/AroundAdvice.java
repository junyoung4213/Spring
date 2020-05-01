package com.springstudy.biz.common.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[Around Before] : 비즈니스 메서드 수행 전 처리...");
		Object returnObj = pjp.proceed();
		System.out.println("[Around After] : 비즈니스 메서드 수행 후 처리...");

		return returnObj;
	}
}
