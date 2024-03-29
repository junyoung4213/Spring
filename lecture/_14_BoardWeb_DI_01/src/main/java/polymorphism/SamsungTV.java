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
 * 1) 메서드에서 필요할 때마다 객체를 생성한다(리소스 소요)
 * 2) 객체를 직접적으로 할당해서 사용하므로 
 *    변경시 수정할 부분이 많이 생김
*/

public class SamsungTV implements TV {

//	private SonySpeaker speaker;
	
	private AppleSpeaker speaker;

	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}

	public void volumeUp() {
//		speaker = new SonySpeaker();
		speaker = new AppleSpeaker();
		speaker.volumeUp();
	}

	public void volumeDown() {
//		speaker = new SonySpeaker();
		speaker = new AppleSpeaker();
		
		speaker.volumeDown();
	}
}
