package thread.priority;

public class ThreadPriority {

	public static void main(String[] args) {
		//10개의 thread 생성 동시 실행 - 10번 thraed 는 우선순위 높게 나머지는 우선순위 낮게 설정
		for(int i=0;i<10;i++) {
			Thread thread = new CalcThread("thread"+ i);
			if(i!=10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			}else {
				thread.setPriority(Thread.MAX_PRIORITY);

			}
			thread.start();
		}

	}

}
