package collectionbean;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanMain {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionMap bean = (CollectionMap) factory.getBean("collectionMap");
		Map<String, String> addressMap = bean.getAddressMap();
		for (String name : addressMap.keySet()) {
			System.out.println(name + " : " + addressMap.get(name));
		}
		factory.close();
	}
}
