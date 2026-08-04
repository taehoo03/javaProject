package thread.sync;

//공통 객체로 사용할 클래스
public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);			
		}catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+": " + this.memory);
	}
	}