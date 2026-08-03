package nestedclass;
//중첩된 클래스들도 클래스이므로 독립적인 바이트코드 파일로 생성됨
 //바깥 클래스
public class A {
	A(){System.out.println("A객체가 생성됨");}
	
	
	//** 인스턴스 멤버 클래스  : 바깥 클래스 객체를 생성해야 접근(객체 생성) 가능**//
	public class B{
		B(){System.out.println("B객체가 생성됨");}
		int field1;
		void method1() {}
		//static int field2;
		//static void method2() {};
		
	}
	
	//** 정적(static) 멤버 클래스 **//
	static class C{
		C(){System.out.println("C 객체가 생성됨");}
		int field;
		void method1() {}
		static void method2() {};
	}
	
	//** 로컬(method 내부에 선언) 클래스 **//
	void method() {
		/** 로컬클래스:인스턴스 필드와 메소드만 포함가능
		 * 메소드 호출 시점에 로컬 클래스는 메서드 저장영역(메모리)에 JVM에의해 저장됨
		 * 로컬 클래스 삭제는 프로그램이 종료되면 삭제됨 **/
		class D{
			D(){System.out.println("D 객체가 생성됨");}
			int field1;
			void method1() {};
		}
		D d = new D();// 현 시점(메소드 호출되면)에서 생성 메소드 실행이 종료되면 제거ㅇ됨
		d.field1 =3;
		d.method1();
		
	}//메소드 호출이 종료되면 생성한 instance는 제거됨 참조를 중단 후 재사용 가능
}
