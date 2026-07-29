package interfaceex.extend1;

public class DefaultMethodExtendsEx {

	public static void main(String[] args) {
		// 익명 구현 객체 사용시 1회성 클래스
		ChildInterface1 ci1 =new ChildInterface1() {
			
		@Override 
		public void method1() {
			System.out.println("c1-m1()");
		}
		
		@Override 
		public void method3() {
			System.out.println("c1-m3()");
		}
		
	};

	ci1.method1();
	ci1.method2();
	ci1.method3();
	
	// childInterface2(디폴트메서드 재정의 )를 구현하는 익명객체
	ChildInterface2 ci2 = new ChildInterface2() {
		
		@Override 
		public void method1() {
			System.out.println("c2-m1()");
		}
		
		@Override 
		public void method3() {
			System.out.println("c2-m3()");
		}
		
	};
	ci2.method1();
	ci2.method2();
	ci2.method3();
	
	
	}

}
