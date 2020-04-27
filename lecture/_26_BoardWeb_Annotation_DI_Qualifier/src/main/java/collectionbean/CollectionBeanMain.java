package collectionbean;

import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanMain {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionProperties bean = (CollectionProperties) factory.getBean("collectionProperties");
		Properties addressProperties = bean.getAddressProperties();
		for (Object name : addressProperties.keySet() ) {
			System.out.println(name + " : " + addressProperties.get(name));
		}
		factory.close();
	}
}
