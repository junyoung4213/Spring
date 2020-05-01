package com.springstudy.biz.common.log;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[before Running]" + method + "() 메서드 arguments 정보" + args[0].toString());

	}
}
