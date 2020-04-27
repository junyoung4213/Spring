package polymorphism;

/*
 * SamsungTV와 SonySpeaker간에는 결합도가 강한 요소가 
 * 있다. 
 * 1) SonySpeaker가 여러 군데 생성되어 리소스 낭비
 * 2) 다른 Speaker로 교체할 때 2개의 메서드 모두 수정
*/

public class SamsungTV implements TV {

	private SonySpeaker speaker;

	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}

	public void volumeUp() {
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
