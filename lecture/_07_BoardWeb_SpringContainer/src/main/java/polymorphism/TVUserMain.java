package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserMain {
	public static void main(String[] args) {
		// 1. Spring Container를 구동한다
		String contextFile = "applicationContext.xml";
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext(contextFile);
		
		// 2. Spring Container로부터 객체를 요청(Look up)
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		// 3. Spring Container 종료
		factory.close();
	}
}
