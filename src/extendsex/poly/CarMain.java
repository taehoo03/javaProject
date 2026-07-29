package extendsex.poly;

public class CarMain {

	public static void main(String[] args) {
		//다형성 예제
		Car car = new Car();
		for(int i =1;  i<=5;  i++) {
			int problemLocation =car.run();
			
			switch(problemLocation) {
			case 1:
				System.out.println("앞 왼쪽 HankookTire 로 교체");
				car.frontLeftTire =new HankookTire("앞 왼쪽",15);
				break;
			case 2:
				System.out.println("앞 왼쪽 KumhoTire 로 교체");
				car.frontRightTire =new KumhoTire("앞 오른쪽",15);
				break;
				
			case 3:
				System.out.println("뒤 왼쪽 KumhoTire 로 교체");
				car.backLeftTire =new KumhoTire("뒤 왼쪽",15);
				break;
				
			case 4:
				System.out.println("뒤 오른쪽 HankookTire 로 교체");
				car.backRightTire =new HankookTire("뒤 오른쪽",15);
				break;
			}
			
			}
		}

	}


