package stack;

public class Stack {
	private int stackSize;//스택 크기
	private int top; // 스택포인터
	private char[] stackArr; // 스택
	
	//생성자 : 스택 초기화
	//배열 index는 0부터 시작하므로 top은 -1로 초기 값 설정
	public Stack(int stackSize) {
		this.stackSize = stackSize;
		this.top =-1;
		this.stackArr = new char[stackSize];
	}
	
	//stack 기능 구현
	
	//스택이 비어있는가?
	public boolean isEmpty() {
		return top ==-1;
	}
	
	//스택이 가득 찼는가?
	public boolean isFull() {
		return top ==stackSize-1;
	}
	
	
	//push -> 데이터 삽입
	public void push(char item) {
		if(isFull()) {
			System.out.println("Stack Full. Onerflow");
			
		}else {
			//top을 증가한 후 데이터 저장
			stackArr[++top] = item;
		}
	}
	//pop ->데이터 삭제
	//삭제할 데이터가 있는지 확인: underflow
	public char pop() {
		if(isEmpty()) {
			System.out.println("StackEmpty");
			return 'E';
		}else {
			//현재 top위치의 data 반환하고 top-1
			return stackArr[top--];
		}
		//저장된 데이터중 가장 최근에 저장된 데이터를 반환
		//top 위치의 데이터 반환
		public char peek() {
			if(isEmpty()) {
				System.out.println("StackEmpty");
				return 'E';
			}else {
				return stackArr[top++];
	}
			
			//스택을 비움
			public void clear() {
				top =-1;
			}
			//스택내 저장된 모든 데이터 출력
			//dump
			public void showStack() {
				if(isEmpty()) {
					System.out.println("Stack Empty");
					
				}else {
					System.out.println("Stack items : ");
					for(int i=0; i<top;i++) {
						System.out.println(i+ " : " + stackArr[i] + " ");
					}
					System.out.println("\ntop:" + top);
				}
			}
}
