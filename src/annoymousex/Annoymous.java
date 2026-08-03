package annoymousex;

public class Annoymous {
	Person field =new Person() {
		//Person 을 상속받은 익명객체의 구현부
		
		//익명객체 일반 메서드
		void work() {
			System.out.println("출근합니다");
		}
		//상속 받은 매서드 재정의
		@Override
		void wake() {
			System.out.println("6시에 일어납니다");
			work();
		}
	};

//로컬변수를 초기화 할 때 익명 자식객체 사용
//멤버 메소드
void method1() {
	//로컬 변수의 값으로 익명 자식객체 인스턴스 대입
	Person localVar =new Person() {
		System.out.println("산책합니다");
	}
	@Override
	void wake() {
		System.out.println("7시에 일어납니다");
		this.work();
	}
};

localVar.wake();
}

void method2(Person person) {
	person.wake();
}
