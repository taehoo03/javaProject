package thread.extendsthread;

import java.awt.Toolkit;

public class WorkerThread extends Thread{

	@Override
	public void run() { Toolkit toolkit = Toolkit.getDefaultToolkit();
	 
	 for(int i =0;i<5;i++) { toolkit.beep(); try
	  {Thread.sleep(500);}catch(Exception e) {}
	  } 
	  } 
});
}
