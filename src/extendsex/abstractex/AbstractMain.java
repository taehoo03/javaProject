package extendsex.abstractex;

public class AbstractMain {

	public static void main(String[] args) {
		// 추상 클래스 활용 예시
		//추상 클래스는 독립적인 객체 인스턴스 생성 불가능 함
		//Animal ani =new Animal);
		
		Dog dd =new Dog();
		Cat cc= new Cat();
		
		dd.show();
		dd.sound(); // 추상 메서드가 구현된 메서드 호출
		
		//추상 클래스는 단독객체 생성은 불가능하지만 서브클래스 객체 생성시에 같이 생성됨
		cc.show();//Cat 클래스에서는 show 메서드 재정의 하지 않음 Animal클래스의 일반메서드 show 호출
		cc.sound();
		
		//추상 클래스 참조변수에 서브클래스 인스턴스 대입이 가능
		Animal ani = new Cat();
		ani.show();
		ani.sound();
		
		ani =new Dog();
		ani.show();
		ani.sound();

	}

}
