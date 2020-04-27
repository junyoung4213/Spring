package polymorphism;

/*
 * SamsungTV와 SonySpeaker간에는 결합도가 강한 요소가 
 * 있다. 
 * 1) SonySpeaker가 여러 군데 생성되어 리소스 낭비
 * 2) 다른 Speaker로 교체할 때 2개의 메서드 모두 수정
*/

/*
 * SonySpeaker -> AppleSpeaker로 교체하자
 * 이 소스는 결합도가 강해서 3군데를 수정해야 한다.
*/

public class SamsungTV implements TV {

	private Speaker speaker;
	private int price = 0;

	public SamsungTV(Speaker speaker) {
		System.out.println("SamsungTV --- 객체 생성.");
		this.speaker = speaker;

	}

	public SamsungTV(Speaker speaker, int price) {
		this(speaker);
		this.price = price;
	}

	public void powerOn() {
		System.out.print("SamsungTV --- 전원 켠다.");
		System.out.println(" (가격: " + price + ")");
	}

	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
