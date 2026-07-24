package classInfo;

public class FinalEx {

	//인스턴스에 적용되는 final , 모든 클래스 공유 불가
	public static void main(String[] args) {
		//final 필드 사용
		Final f1 =new Final("123456789-56789","계백");
		
		System.out.println(f1.nation);
		System.out.println(f1.ssn);
		System.out.println(f1.name);
		
		f1.nation="japan";
		f1.ssn ="5555-6666";
		f1.name ="을지문덕";
	}

}
