package thread.multimain;

import java.awt.Toolkit;

//Runable 인터페이스 run추상메서드 하나가 포함되어 있음
//재정의 할때 스레드가 동작할 코드
public class BeepTask implements Runnable{
	@Override
	public void run() {
		Toolkit toolkit =Toolkit.getDefaultToolkit();
		
		for(int i =0;i<5;i++) {
			toolkit.beep();
			try {Thread.sleep(500);}catch(Exception e) {}
		}
		
	}

}
