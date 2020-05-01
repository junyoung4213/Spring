package com.springstudy.biz.common.log;

public class AfterAdvice {
	public void finallyLog() {
		System.out.println("[finally Running] 비즈니스 로직 수행 후 무조건 동작");
	}
}
