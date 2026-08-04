package thread.sync;

public class SyncMain {

	public static void main(String[] args) {
		//동기화 없는 쓰레드 간의 공통 객체 사용 예
		Calculator calc = new Calculator(); //공통 객체
		
		User1 user1 = new User1();
		user1.setCalculator(calc);//객체 전달
		user1.start();//memory -> 100 설정
		
		User2 user2 = new User2();
		user2.setCalculator(calc);//
		user2.start();//memory -> 50 설정

	}

}
