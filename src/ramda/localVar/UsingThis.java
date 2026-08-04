package ramda.localVar;
//매서드 내부에서 함수형 인터페이스 참조변수 사용 예시
public class UsingThis {
	public int outterField =10;
	public int field =100;
	
	class Inner{
		int innerField = 20;
		int field =200;
		
		void method(int arg) {
			//로컬 변수
			int localVar =40;
			int localVar2;
			localVar2 =60;
			//로컬 변수 람다식 구현시 final 특성 제약사항
			MyFunctionalInterface fi = () ->{
				//로컬 변수 사용
				System.out.println("arg :" + arg);
				System.out.println("localVar :" + localVar);
				System.out.println("localVar2 :" + localVar2);

				
				//바깥 클래스 중첩클래스 필드의 이름이 다른경우 바로 접근
				System.out.println("outterField : "+ outterField);
				System.out.println("innerField : "+ innerField);
				
				
				//바깥클래스 중첩클래스 필드의 이름이 같은경우 inner 클래스 접근
				System.out.println("outter : "+ field);
				System.out.println("inner : "+ field);
				
				//바깥클래스 중첩클래스 필드의 이름이 같은경우 this 활용
				//outter 접근 바깥 클래스명.this.필드명
				System.out.println("outter : "+ UsingThis.this.field);
				System.out.println("inner : "+ this.field);
			};
			fi.method();
		}
	}
}
