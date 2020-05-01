package com.springstudy.biz.common.log;

public class BeforeAdvice {
	public void beforeLog() {
		System.out.println("[before Running] 비즈니스 로직 수행 전 동작...");
	}
}
