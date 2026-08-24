package datastructure.queue.Parking;


//Queue
//데이터 삽입시 앞이 비었음에도 어버플로우 발생
public class MyQueue {

	
	private int queueSize;
	private int front;//첫번쨰 요소 앞
	private int rear;//마지막 요소
	private int num;
	private char[] queue;
	
	public MyQueue(int queueSize) {
		this.front = this.rear = -1;
		this.num =0;
		this.queueSize = queueSize;
		queue = new char[queueSize];
	}
	//front 와 rear 값이 동일하면 데이터가 없는 상태
	public boolean isEmpty() {
		if(front ==rear) {
			front =rear = -1;//큐가 바뀌었으므로 모든 공간 사용 가능한 상태로 초기화
		}
		return front ==rear;
	}
	
	//rear 포인터가 큐의 마지막 인덱스와 동일하면 full 상태
	public boolean isFull() {
		return(rear ==queueSize-1);
	}
	//큐에 데이터 삽입
	//반환 값 수정 :ㅣ 개발코드(main)에서 enqueue 결과에 따라 다른 처리 해야함
	public boolean  enqueue(char item) {
		if(isFull()) {//마지막에 지정된 데이터가 큐의 마지막 원소로 저장되면 Full
			System.out.println("Queue Full");
			return false;
		}else {
			queue[++rear] = item;
			num++;
			return true;
		}
	}
	
	//큐에서 데이터 삭제
	public char dequeue() {
		if(isEmpty()) {
			System.out.println("큐 비었습니다");
			return 'E';
		}else {
			num--;
			front++;
			return queue[front];//queue의 front 포잍너는 삭제할 데이터의 앞 index를 참조하고 있습니다
			
		}
	}
	
	//큐의 첫번째 데이터 추출(저장된지 가장 오래된 데이터)
	public char peek() {
		if(isEmpty()) {
			System.out.println("peek 실패 Empty!");
			return 'E';
		}else {
			return queue[front+1];
		}
	}
	
	//큐 초기화
	public void clear() {
		front = rear =-1;
		System.out.println("clear!");
	}
	
	public int size() {
		return num;
	}
	
	
	//큐에 저장된 모든 데이터를 출력
	public void showQueue() {
		if(isEmpty()) {
			System.out.print("Queue Empty");
		}else {
			System.out.print("Queue items :");
			for(int i=front+1;i<rear;i++) {
				System.out.println(i+":"+queue[i]+ " ");
			}
			System.out.println();
		}
	}
	//전달된 data 가 queue에 저장된 데이터인지 확인 후 해당 인덱스 반황
	//현재 주차 확인중인 차량에 대하여 출차시 선행차량 대수 확인용으로 변경
	
	public int contains(char value) {
		if(isEmpty()) {
			System.out.println("Queue Empty!");
			
		}else {
			
			for(int i = front+1; i<rear; i++) {
				if(queue[i] ==value) {
					return i - (front +1); //  i : 현재 확인 중인 원수의 index - 첫번째 dequeue 대상 원소dml index
				}
			}
			}
		return-1; // 해당 value가 queue에 없음
	}
	
}
