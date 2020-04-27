package polymorphism;

import org.springframework.stereotype.Component;


// id, name을 지칭하지 않으면 lgTV로 bean을 요청할 수 있다.
@Component
public class LgTV  implements TV{
	
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
		System.out.println("LgTV --- 소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("LgTV --- 소리 내린다.");
	}
}
