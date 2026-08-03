package nestedInterface;

public class ButtonMain {

	public static void main(String[] args) {
		/*
		 * // 중첩 인터페이스 interface OnClickListener{ void onClick(); }
		 */
		//중첩 인터페이스 객체 사용 방법 예시
		Button btn =new Button();
		
		//버튼 클릭시 이벤트 처리
		//CallListener 구현 객체 사용
		btn.setListener(new CallListener());
		btn.touch();
		
		btn.setListener(new MessageListener());
		btn.touch();
		
		//구현객체 사용하지 않고 익명 객체 직접 연결해서 클릭시 발생할 처리내용을 결정
		Button2 btn2 =new Button2();
		btn2.setListener(
				new Button2.OnClickListener() {
					
					@Override
					public void onClick() {
						System.out.println("사진을 찍습니다");
					
					}
				}); //setListener 메소드 호출 종료
				
				btn2.touch();
		
	}

}
