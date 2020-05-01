package com.springstudy.biz.common.log;

import org.aspectj.lang.JoinPoint;

import com.springstudy.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();

		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if (user.getRole().equals("admin")) {
				System.out.println(user.getName() + " 로그인(Admin)");
			}
		}
		System.out.println("[After Returning] " + method + "() 메서드 리턴값 : " + 
		
				(returnObj!=null ? returnObj.toString() : "null"));
	}
}
