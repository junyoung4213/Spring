package com.springstudy.biz.common.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	// 포인트 컷 (핵심관심 - 대상)
	@Pointcut("execution(* com.springstudy.biz..*ServiceImpl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.springstudy.biz..*ServiceImpl.get*(..))")
	public void getPointcut() {}
	
	// 어드바이스 설정(횡단관심 - 적용)
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[Common Log] 비즈니스 수행 전 동작");
	}
}










