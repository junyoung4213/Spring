package com.springstudy.biz.common.log;

public class AfterReturningAdvice {
	public void afterLog() {
		System.out.println("[After Returning] 비즈니스 로직 수행 후 동작...");
	}
}
