package interfaceex.extend1;

public interface ChindInterface2 extends ParentInterface{
	//상속받은 default 메서드 재정의
	@Override
	public default void method2() {
		System.out.println("c2 -m2()");
	}
	
	public void method3();
}
