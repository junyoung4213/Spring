package polymorphism;

/* 결합도(Coupling)가 앞의 프로그램보다
 * 낮아졌다
 * 
 * 메서드명의 표준이 정해져서
 * 클래스 객체 선언만 교체해도 잘 돌아간다
 */
public class TVUserMain {
	public static void main(String[] args) {
		//SamsungTV tv = new SamsungTV();
		LgTV tv = new LgTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}
}







