package com.springstudy.biz.common.log;

public class AfterThrowingAdvice {
	public void exceptionLog() {
		System.out.println("[After Exception] 비즈니스 로직 수행중 예외 발생");
	}
}
