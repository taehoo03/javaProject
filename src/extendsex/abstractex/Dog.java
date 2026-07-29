package extendsex.abstractex;

public class Dog extends Animal{
	//추상 클래스 상속받은 경우 추상 메서드는 반드시 구현
	@Override
	public void sound() {
		Systeem.out.println("멍멍");
	}
}
