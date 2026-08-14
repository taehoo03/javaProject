package stack.generic;

import java.util.EmptyStackException;

//generic 타입의 클래스로구성하고 객체생성시 타입 결정
public class StackGeneric<E> {
	private int stackSize;//스택 크기
	private int top;//스택 포인터
	private Object[] stackArr;//스택 -> 모든 타입 처리 가능하도록  generic 타입으로 구성
	
	//생성자 : 스택 초기ㅗ하
	//배열 인덱스는0부터 시작하므로 top은 -1로 초기값 설정
	public StackGeneric(int stackSize) {
	    this.stackSize = stackSize;
	    this.top = -1;
	    this.stackArr = new Object[stackSize];
	}
	
	public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackSize - 1;
    }

    public void push(E item) {
        if (isFull()) {
            System.out.println("Stack Full. Overflow");
        } else {
        	//object 타입 배열에 저장- > 제너릭 타입이므로 나중에 item의 타입은 결정됨
        	//Object 는 최상위 클래스 이므로 어떤 타입도 저장 가능
            stackArr[++top] = item;
        }
    }
    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            //제네릭 타입을 반환해야하는 경우에 예외 상황이면 예외를 던지는 방법을 많이 사용함
            throw new EmptyStackException();
        } else {
        	//Object 타입을 E타입으로 형변환(E)
        	@SuppressWarnings("unchecked")
        	E item = (E) stackArr[top--];
            return item;
        }
    }
    
    public E peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            throw new EmptyStackException();
        } else {
        	E item = (E) stackArr[top];
            return item;
        }
    }
    
    public void showStack() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
        } else {
            System.out.println("Stack items : ");

            for (int i = 0; i <= top; i++) {
                System.out.println(i + " : " + stackArr[i]+" ");
            }

            System.out.println("\ntop : " + top);
        }
    }

    public int size() {
        return top + 1;
    }

    public int getCapacity() {
        return stackSize;
    }

}
