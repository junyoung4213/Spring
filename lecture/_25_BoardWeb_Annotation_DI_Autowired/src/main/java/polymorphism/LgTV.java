package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// id, name을 지칭하지 않으면 lgTV로 bean을 요청할 수 있다.
@Component("tv")
public class LgTV  implements TV{
	
	/*
	 * 메모리에 로딩된(factory에 있는)
	 * bean중에 Speaker 타입이 있으면
	 * 자동으로 injection 해줘
	*/
	
	@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("LgTV --- 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("LgTV --- 전원 켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV --- 전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
