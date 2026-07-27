package extendsex;


class SuperClass{
	int x;
	int y;
	
	public SuperClass() {
		x =5;
		y=10;
	}
}
//SuperClass의 필드가 default이므로 동일 패키ㅣ 클래스인 sub에서는 필드 모두 사용 가능(상속)
class SubClass extends SuperClass{
	int x;
	public SubClass() {
		x=10;
	}
	
	public void show() {
		System.out.println(x); //SubClass에 x 필드가 있음 : SuperClass x 가 출력
		System.out.println(y); //SubClass에 y필드가 있음 : SuperClass y가 출력;
		//super 클래스의 x 출력
		System.out.println("super 의 x : " + super.x); //Super와 Sub가 필드명이 중복되는 경우 Super가 포함하는 필드를 의미
		System.out.println("sub의 x :" + this.x); // Sub 클래스의 x필드를 명시적으로 표현
		System.out.println("super 의 y : " + super.y)
	}
}

public class SuperEx {

	public static void main(String[] args) {
		//super this 활용 예시
		SubClass sc =new SubClass();
		sc.show();

	}

}
