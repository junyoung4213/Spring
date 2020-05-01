package com.springstudy.biz.common.log;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println(method + "() 메서드 수행 중 예외 발생!");

		if (exceptObj instanceof IllegalArgumentException) {
			System.out.println("잘못된 매개변수 예외");
		} else if (exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다 예외");
		} else if (exceptObj instanceof Exception) {
			System.out.println("예외가 발생했습니다!");
		}

	}
	/*
	 * public void exceptionLog(JoinPoint jp, Exception exceptObj) { String method =
	 * jp.getSignature().getName();
	 * 
	 * System.out.println("[After Exception] " + method + "() 메서드 수행 중 발생 예외 : " +
	 * exceptObj.getMessage()); }
	 */
}
