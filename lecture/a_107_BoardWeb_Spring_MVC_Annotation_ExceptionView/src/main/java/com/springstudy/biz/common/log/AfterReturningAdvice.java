package com.springstudy.biz.common.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springstudy.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	@Pointcut("execution(* com.springstudy.biz..*ServiceImpl.get*(..))")
	public void getPointcut() {}
	
	@AfterReturning(pointcut="getPointcut()",
					returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("Admin"))
				System.out.println(user.getName() + 
						" 로그인(Admin)");
		}
		
		System.out.println("[After Returning] " + 
				method + "() 메서드 리턴값 : " +
				returnObj.toString());
	}
}










