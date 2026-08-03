package annoymousex.interfaceex.ui;

public class Window {
	Button button1 = new Button();
	Button button2 = new Button();
	
	Button.OnClickListener listener = new Button.OnClickListener() {
		@Override
		public void onClick() {
			System.out.println("전화를 겁니다")
		}
	};
	
	Window(){
		//미리 생성한 필드를 파라미터로 전달
		button1.setListener(listener);
		
		button2.setListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("메세지를 보냅니다")
			}
		});
		
		
}
	
}
