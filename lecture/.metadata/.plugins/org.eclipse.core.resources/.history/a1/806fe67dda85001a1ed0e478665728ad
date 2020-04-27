package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserMain {
	public static void main(String[] args) {
		// 1. Spring Container를 구동한다
		String contextFile = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(contextFile);

		TV tv = (TV) factory.getBean("lgTV");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

		// 3. Spring Container 종료
		factory.close();
	}
}
