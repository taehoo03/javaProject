package datastructure.queue;

// Queue
// 데이터 삽입 시 앞이 비었음에도 오버플로우 발생
public class MyQueueGeneric<T> {

	private int queueSize;
	private int front; // 첫 번째 요소 앞
	private int rear;  // 마지막 요소
	private int num;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public MyQueueGeneric(int queueSize) {
		this.front = this.rear = -1;
		this.num = 0;
		this.queueSize = queueSize;
		queue = (T[]) new Object[queueSize];
	}

	// front와 rear 값이 동일하면 데이터가 없는 상태
	public boolean isEmpty() {
		if (front == rear) {
			front = rear = -1;
		}
		return front == rear;
	}

	// rear 포인터가 큐의 마지막 인덱스와 동일하면 full 상태
	public boolean isFull() {
		return rear == queueSize - 1;
	}

	// 큐에 데이터 삽입
	public void enqueue(T item) {
		if (isFull()) {
			System.out.println("Queue Full");
		} else {
			queue[++rear] = item;
			num++;
		}
	}

	// 큐에서 데이터 삭제
	public T dequeue() {
		if (isEmpty()) {
			System.out.println("큐 비었습니다");
			return null;
		} else {
			num--;
			front++;
			return queue[front];
		}
	}

	// 큐의 첫 번째 데이터 추출
	public T peek() {
		if (isEmpty()) {
			System.out.println("peek 실패 Empty!");
			return null;
		} else {
			return queue[front + 1];
		}
	}

	// 큐 초기화
	public void clear() {
		front = rear = -1;
		num = 0;
		System.out.println("clear!");
	}

	public int size() {
		return num;
	}

	// 큐에 저장된 모든 데이터를 출력
	public void showQueue() {
		if (isEmpty()) {
			System.out.print("Queue Empty");
		} else {
			System.out.print("Queue items : ");

			for (int i = front + 1; i <= rear; i++) {
				System.out.print(i + ":" + queue[i] + " ");
			}

			System.out.println();
		}
	}

	public int contains(T value) {
		if (isEmpty()) {
			System.out.println("Queue Empty!");
		} else {
			for (int i = front + 1; i <= rear; i++) {
				if (queue[i].equals(value)) {
					return i;
				}
			}
		}

		return -1;
	}
}