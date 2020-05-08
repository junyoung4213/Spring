package com.springstudy.biz.common.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.springstudy.biz..*ServiceImpl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.springstudy.biz..*ServiceImpl.get*(..))")
	public void getPointcut() {}
}





