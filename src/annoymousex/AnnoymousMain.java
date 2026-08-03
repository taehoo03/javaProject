package annoymousex;

public class AnnoymousMain {

	public static void main(String[] args) {
		// 익명객체로 초기화된 클래스 필드 사용
		Annoymous annoy =new Annoymous();
		
		//익명객체로 초기화된 필드를 통해 재정의 된 메소드 호출
		annoy.field.wake();
		//annoy.field.work();
		
		//로컬 변수가 익명자식객체로 값이 대입된 메소드 호출
		annoy.method1();
		
		//매개변수에 전달되는 파라미터의 값으로 Person을 상속받는 익명 자식 객체 인스턴스
		annoy.method2(new Person() {
			
			void study() {
				System.out.println("공부합니다");
			}
			@Override
			void wake() {
				System.out.println("8시에 일어납니다");
				study();
			}
		});

	}

}
