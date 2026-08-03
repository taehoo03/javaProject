package nestedclass.access.local;

public class Outter {
public void method2(int arg1) {
	int localVariable1 =1;
	
	class Inner{
		public void method() {
			//처리 진행 시 매개변수나 로컬변수 사용시 final 인것만 사용하기
			int result =arg1 + localVariable1;
		}
	}
}
}
