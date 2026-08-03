package nestedInterface;

import nestedInterface.Button.OnClickListener;

public class Button2 {
	OnClickListener listener; 
	
	//구현 객체 따로 만들지 않고
	//클래스 내부에서 직접 익명 객체 대입해서 이벤트 처리하는 경우가 더 많다
	public void setListener (OnClickListener listener) {
		this.listener =listener;
	}
	
	
	void  touch() {
		
		listener.onClick();
	}
	interface OnClickListener{
		void onClick();
	}
}
