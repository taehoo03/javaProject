package datastructure.queue;

public class MyQueueMoveMain {

	public static void main(String[] args) {
		// 구현한 queue 사용
		int queueSize = 5;
		MyQueueMove q = new MyQueueMove(queueSize);

		q.showQueue();
		System.out.println("데이터 수:" + q.size());

		System.out.println("\na,b,c 삽입 수행");
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.showQueue();
		System.out.println("데이터 수:" + q.size());

		System.out.println("\n 첫번째 값 확인(peek수행) : " + q.peek());
		System.out.println("\ndeque 수행");
		System.out.println("\n 반환(삭제 )된 값 : " + q.dequeue());
		System.out.println("\n 반환(삭제 )된 값 : " + q.dequeue());
		q.showQueue();
		System.out.println("데이터 수: " + q.size());
		
		System.out.println("\nd enqueue 수행");
		q.enqueue('d');
		q.showQueue();

		/*
		  System.out.println("\n 첫번째 값 확인(peek수행) : " + q.peek());
		  
		  System.out.println("\nd,e 삽입 수행"); q.enqueue('d'); q.enqueue('e');
		  q.showQueue(); System.out.println("데이터 수:" + q.size());
		  
		  System.out.println("\nd, f 삽입 수행"); q.enqueue('f');
		  //데이터가 4개이고 0 위치가 비었음에도FULL 출력 
		  // -> rear와 queueSize -1 이 동일하면 오버 플로우 발생 //-> 해결하려면 : 이동 큐 , 원형큐
		  
		  System.out.println("\nclear 수행"); q.clear(); q.showQueue();
		  
		  System.out.println("\nx enqueue 수행"); q.enqueue('x'); q.showQueue();
		  */
		 
	}

}
