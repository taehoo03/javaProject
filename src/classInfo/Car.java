package classInfo;

public class Car {

	
	//클래스 구성요소 필드(속성,변수) + 메소드(기능,함수)
		
		
		//필드
		String carNo;
		String carName;
		String carMaker;
		int carYear;
		int carCc;
		
		//매소드 :  객체를 통해 어디서든 접근 가능(public), 반환값 없음 : void
		public void showCarInfo(){
			System.out.println("차량번호 : " + carNo);
		
		}
}
