package polymorphism;

/* interface를 통해 결합도(Coupling)를
 * 낮춘다.
 * 
 * interface변수에는 모든 자식클래스 객체가
 * 대입될 수 있다.
 */
public class TVUserMain {
	
	public static void ViewTV(TV tv) {
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();		
	}
	
	public static void main(String[] args) {
		ViewTV(new SamsungTV());
		ViewTV(new LgTV());
		ViewTV(new BitTV());	
	}
}







