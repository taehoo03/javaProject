package generic.object;

public class NonGenMain {

	public static void main(String[] args) {
		//모든 타입의 데이터를 필드에 저장하는 Box 클래스 사용 예시
		Box box = new Box();
		box.set("홍길동");//String - > Object
			
		
		Box box1 =new Box();
		box1.set(7); // int -> Object
		
		Box box2 =new Box();
		box2.set(2.15); // double -> Object
		
		//각 박스에서 상품을 추출
		//문자열 상품
		String name = (String)box.get(); //object -> string 변환 불가 오류
		//정수 박스
		int no =(int)box2.get();
		
		//실수 박스
		double pi =(double)box2.get();
				

	}

}
