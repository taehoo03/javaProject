package annoymousex.interfaceex;

public class Annoymous {
	// 인터페이스 타입의 필드 초기값으로 익명 구현 객체 사용
	IRemoteControl field = new IRemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다");
			
		}
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다");
		}
	};
	void method1() {
		//인터페이스 타입의 로컬변수 선언 대입
		IRemoteControl localVar = new IRemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("오디오 켜기");
			}
			@Override
			public void turnOff() {
			System.out.println("오디오 끄기");
			}
			
		};
		localVar.turnOn();
	}

}
