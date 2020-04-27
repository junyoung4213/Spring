package collectionbean;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanMain {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionSet bean = (CollectionSet) factory.getBean("collectionSet");
		Set<String> addressSet = bean.getAddressSet();
		for (String address : addressSet) {
			System.out.println(address.toString());
		}
		factory.close();
	}
}
