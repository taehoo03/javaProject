package stack;

public class StackMain {

	public static void main(String[] args) {
		// Stack 클래스 활용 예시
		int stackSize =5;
		
		//Stack 객체 생성
		Stack stk  = new Stack(stackSize);
		
		System.out.print("스택 초기상태 :");
		stk.showStack();
		
		System.out.println("\npop 수행");
		stk.pop();
		
		System.out.println("\na, b,bc push 수행");
		stk.push('a');
		stk.push('b');
		stk.push('c');
		
		stk.showStack();
		
		System.out.println("\n최상위 값 : " + stk.peek());

		public void size() {
			//stack의 data 수 return
		}
		
		public void getCapacity() {
			//전체 stack 용량 return
		}
	}

}
