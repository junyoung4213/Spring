package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserMain {
	public static void main(String[] args) {
		// 1. Spring Container를 구동한다
		String contextFile = "applicationContext.xml";
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext(contextFile);
		
		// 2. 기본적으로 Container는 singleton 속성을 가진다
		//	     계속 같은 객체이다
		TV tv0 = (TV)factory.getBean("tv");
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		System.out.println(tv0);
		System.out.println(tv1);
		System.out.println(tv2);
		
		// 3. Spring Container 종료
		factory.close();
	}
}
