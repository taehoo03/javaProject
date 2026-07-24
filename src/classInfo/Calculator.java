package classInfo;

public class Calculator {
	//메소드 구성
	//접근 제한자 생략 : protected (동일 패키지 내에서 접근 가능)
	void powerOn() {
		System.out.println("전원을 켭니다")
	}
	int plus(int x, int y) {
		int result =x+y;
		return result;
	}
	double divide(int x ,int y) {
		return (double)x/(double)y;
	}
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	
	//클래스에는 포함되지 않고 메소드 독립적으로 jvm에 의해 처리
	//main을 포함하고 있는 클래스의  객체 생성 가능
	
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int result1 = myCalc.plus(5, 6);
		System.out.println("result : " + result1);
		
		byte x =10; byte y= 4;
		double result2 = myCalc.divide(x, y);
		myCalc.powerOff();
		
	}
}
