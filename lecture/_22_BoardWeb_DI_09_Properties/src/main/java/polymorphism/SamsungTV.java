package polymorphism;

public class SamsungTV implements TV {

	private Speaker speaker;
	private int price = 0;

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
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
