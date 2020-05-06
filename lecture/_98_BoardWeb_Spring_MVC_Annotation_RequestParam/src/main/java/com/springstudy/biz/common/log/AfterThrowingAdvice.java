package com.springstudy.biz.common.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* com.springstudy.biz..*ServiceImpl.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing(pointcut="allPointcut()",
					throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, 
							Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println(method + "()메서드 수행중 예외 발생!");
		
		System.out.print("[After Throwing] ");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력됨");
		}else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아님");
		}else if(exceptObj instanceof Exception) {
			System.out.println("문제가 발생함");
		}
	}
}









