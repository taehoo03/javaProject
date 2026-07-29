package interfaceex.extend;

public class MultiExtendsinterfaceMain {

	public static void main(String[] args) {
	//인터페이스 상속에서의 다형성
		
		//구현 클래스 객체생성
		
		ImplementationC c =new ImplementationC();
		
		//인터페이스 차모변수에 대입
		
		InterfaceA ia =c;
		ia.methodA();
		//ia.methodB();
		InterfaceB ib =c;
		ib.methodB();
		
		System.out.println("--------------------------");
		//InterfaceA와 InterfaceB를 상속받음으로써 InterfaceC 참조변수는 상속받은 인터페이스 추상메소드
		// 자신 추상메소드 구현체에 접근
		InterfaceC ic =c;
		ia.methodA();
		ib.methodB();
		ic.methodC();
		
		c.methodA();
		c.methodB();
		c.methodC();

	}

}
