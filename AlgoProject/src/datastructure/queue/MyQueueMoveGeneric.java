package datastructure.queue;

// Queue
// 오버플로우 발생 시 dequeue된 공간이 있는 경우 이동해서 오버플로우 해결
public class MyQueueMoveGeneric<T> {

	private int queueSize;
	private int front; // 첫 번째 요소 앞
	private int rear;  // 마지막 요소
	private int num;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public MyQueueMoveGeneric(int queueSize) {
		this.front = this.rear = -1;
		this.num = 0;
		this.queueSize = queueSize;
		queue = (T[]) new Object[queueSize];
	}

	// 큐가 비어있는지 확인
	public boolean isEmpty() {
		if (front == rear) {
			front = rear = -1;
		}
		return front == rear;
	}

	// 큐가 가득 찼는지 확인
	public boolean isFull() {
		return num == queueSize;
	}

	// 큐에 데이터 삽입
	public void enqueue(T item) {

		if (isFull()) {
			System.out.println("enqueue 실패 | Queue Full");

		} else if (rear == queueSize - 1 && num != 0) {

			// 앞쪽의 빈 공간을 이용해서 데이터 이동
			System.arraycopy(queue, front + 1, queue, 0, num);

			System.out.println("큐 이동 발생");

			front = -1;
			rear = num - 1;

			queue[++rear] = item;
			num++;

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

			T item = queue[front];

			// 마지막 데이터까지 삭제된 경우
			if (num == 0) {
				front = rear = -1;
			}

			return item;
		}
	}

	// 큐의 첫 번째 데이터 확인
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

	// 큐 데이터 개수
	public int size() {
		return num;
	}

	// 큐에 저장된 모든 데이터 출력
	public void showQueue() {

		if (isEmpty()) {
			System.out.println("Queue Empty");

		} else {

			System.out.print("Queue items : ");

			for (int i = front + 1; i <= rear; i++) {
				System.out.print(i + ":" + queue[i] + " ");
			}

			System.out.println();
		}
	}

	// 전달받은 값이 큐에 있으면 인덱스 반환
	// 없으면 -1 반환
	public int contains(T value) {

		if (isEmpty()) {
			return -1;
		}

		for (int i = front + 1; i <= rear; i++) {

			if (queue[i].equals(value)) {
				return i;
			}
		}

		return -1;
	}
}