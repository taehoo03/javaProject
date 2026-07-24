package classInfo;

public class Car2 {
	//멤버 필드
	String model;
	int speed;
	
	//생성자 
	Car2(String model){
		//매개변수 model 에 전달된 값을 필드 model 에 저장
		//매개변수 model 에 매개변수로 전달된 model 저장값을 저장
		//model = model;
		//this 참조 사용해서 현재 객체(클래스) 참조하도록 진행
		this.model =model;
	}
	
	//메소드
	void setSpeed(int speed) {
		this.speed =speed;
		
	}
	void run() {
		for(int i=10; i<=100;i+=10) {
			this.setSpeed(i);//객체 자신의 멤버 메소드  호출
			System.out.println(this.model + "가 달립니다.(시속 : " + this.speed+"km/h");
		}
	}
	void run1() {
		for(int i=10; i<=100;i+=10) {
			this.setSpeed(i);//객체 자신의 멤버 메소드  호출
			System.out.println(this.model + "가 달립니다.(시속 : " + this.speed+"km/h");
	}
}
}
