package extendsex.finalex;

public class MyCar { //MyCar2 는 final 클래스 이므로 상속 불가능
			public int speed;
			
			public void speedUp() {
				speed +=1;
			}
			public final void stop() {//재정의 불가는ㅇ 메소드
				System.out.println("차를 멈춤");
				speed =0;
			}
}
