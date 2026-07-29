package interfaceex.extend1;

public interface ChildInterface3 extends ParentInterface {
		//parentinterface에서 상속받은 default 메서드
	@Override
	public void method2();
	
	public void method3() {
		System.out.println("c2-m3()");
	};//추상 메소드
	
	ci2.method1();
	ci2.method2();
	ci2.method3();
	
	ChildInterface ci3 = newChildInterface3(){
		@Override 
		public void method1() {
			System.out.println("c1-m1()");
		}
		@Override
		public void method2() {
			System.out.println("c1-m1()");
		}
		@Override 
		public void method3() {
			System.out.println("c1-m3()");
		}
	};
	ci3.method1();
	ci3.method2();
	ci3.method3();
}

