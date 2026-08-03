package annoymousex.interfaceex;

public class AnnoyMain {

	public static void main(String[] args) {
		// 익명 구현객체로 초기화된 인터페이스 타입의 참조변수 사용
		Annoymous annoy =new Annoymous();
		
		
		annoy.field.turnOn();
		
		//익명 구형객체로 초기화된 인터페이스타입의 로컬변수를 포함하는 메소드 호출
		//메소드에는 로컬변수를 통해 익명객체의 메소드 호출
		annoy.method1();
		
		void method2(IRemoteControl.rc) {
			rc.turnOn();
		}
		

	}

}
