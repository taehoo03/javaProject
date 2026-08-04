package thread.sync;

public class Calculator2 {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//memory 필드의 수정과 조회가 한번에 발생하는 메소드 , 공통 사용하는 경우 한 스레드가 메소드 사용이 종료되기전 다른 스레드가 메서드 사용을 진행
	public synchronized void setMemory(int memory) {
		
		this.memory = memory;
		try {
			Thread.sleep(2000);			
		}catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+": " + this.memory);
	}
	}
