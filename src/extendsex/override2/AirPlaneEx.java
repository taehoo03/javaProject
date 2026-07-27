package extendsex.override2;

public class AirPlaneEx {

	public static void main(String[] args) {
		//super 참조 사용 예시
		SuperAirPlane sa =new SuperAirPlane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SuperAirPlane.SUPERSONIC;
		sa.fly();
		sa.flyMode =SuperAirPlane.NORMAL;
		sa.fly(); //sub class 내부에서 super class 재정의 되기 전 fly() 메소드를 호출하고 있음
		sa.land();
	}

}
