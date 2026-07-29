package nestedclass.access;

public class A2 {
	//바깥 클래스 A2의 인스턴스 멤버필드, 메소드
	int field1;
	void method1() {};
	
	//바깥 클래스 A2의 인스턴스 멤버필드, 메소드
	int field2;
	void method2() {};
	
	class B2{//인스턴스 멤버에서 바깥 클래스 필드와 메서드 접근
		void method() {
			 field1 =3;
			method1() ;
			field2= 2;
			method2();
		}
		
	}
	static class C2{//정적 멤버 클래스클래스 바깥 클래스 필드와 메서드 종류 상관없이 접근해서 사용가능한지
		//정적 멤버 클래스 메서드에서 바깥 클래스의 인스턴스 필드와 메서드는 사용이 불가능합니다
		void method() {
			// field1 =3;
		//	method1() ;
			field2= 2;
			method2();
		}
	}
}
