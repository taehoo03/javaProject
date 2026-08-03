package annoymousex.local;

public class Annoymous {
	private int field;
	public void method(int arg1 ,int arg2) {
		final int var1 =0;
		int var2 =0;
		
		
		//멤버 피으 수정: 멤버 필드는 로컬 클래스나 로컬 익명객체에서 사용가능하고 값이 수정되어도 상관 없음
		field =10;
		var2 =20;//var2는 일반 로컬 변수이고 final의 성질이 없어짐 /메소드에서 사용 불가능
		//익명 객체 참조하는변수
		
		ICalculatable clac = new ICalculatable() {
			@Override 
			public int sum() {
				//익명 객체가 클래스 멤버 메소드 내부에 있음
				//로컬 매개변수 사용할수 있지만 해당 변수들이 fina l이어야 함
				//final이 붙어있지 않은 로컬변수여도 매소드 내에서 초기화 이후 수정되지 않았다면 컴파일러가 final을 붙여줌
				int result = field +arg1 +arg2 + var1+ var2; // 수정하지 않는 로컬 변수 / 매개변수만 사용
				return result;
				
			}
		};
	}
}
