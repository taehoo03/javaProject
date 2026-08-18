	package datastructure.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeArray {
	public static void main(String[] args) {
		Deque<String> dq  = new LinkedList<>(); //LinkedList도 Deque  인터페이스 구현 객체
		System.out.println("데이터 3개 입력");
		dq.add("포도");
		dq.add("배");
		dq.add("수박");
		dq.add("사과");
		System.out.print(dq);
		
		//Deque addFirst() :앞쪽에서 삽입
		System.out.println("\n앞쪽에 삽입");//addFirst
		dq.addFirst("바나나");
		System.out.println(dq);
		dq.add("복숭아");
		System.out.println(dq);
		System.out.println("\n뒤쪽에 삽입"); //addLast add 와 동일
		dq.addLast("복숭아");
		System.out.println(dq);
		
		System.out.println("\npeek :" + dq.peek());
		System.out.println("\nsize :" + dq.size());
		
		
		//데크 순회 : 배열 순회와 같음
		System.out.println("\n데크 순회");
		for(String item :dq) {
			System.out.print(item+ "");		
			}
	
		System.out.println("\n\n 데이터 꺼내기");
		System.out.println("\nremove : "  + dq.remove());
		System.out.println(dq);
		System.out.println("\nremove : "  + dq.remove());
		System.out.println(dq);
		
		//remove값 : 해당값이 deque에 있으면 true 반환 후 원소 삭제
		System.out.println("\nremove : "  + dq.remove("사과"));
		System.out.println(dq);
		
		//remove값 : 해당값이 deque에 여러개 있으면 첫번쨰 값 삭제
		System.out.println("\nremove : "  + dq.remove("복숭아"));
		System.out.println(dq);
		
		//remove값 : 해당값이 deque에 있으면 true 반환 후 원소 삭제
		System.out.println("\nremove : "  + dq.remove("사과"));
		System.out.println(dq);
		
		//removeAll() : 모든 원소 삭제
		System.out.println("\nremove : "  + dq.removeAll(dq));
		System.out.println(dq);
		
		System.out.println("데이터 3개 입력");
		System.out.println(dq.add("포도")); //add 성공하면 true  반환후 용량 초과시exception
		dq.add("배");
		dq.add("수박");
		System.out.println(dq.offer("사과"));
		
		
		//삭제 메소드 : poll
		System.out.println(dq);
		System.out.println("poll : " + dq.poll());
		System.out.println(dq);
		
		System.out.println("pollFirst : " + dq.pollFirst()); //첫 데이터 삭제
		System.out.println(dq);
		
		System.out.println("pollLast : " + dq.pollLast()); //마지막 데이터 삭제
		System.out.println(dq);
		
		
		//addFirst,pollFirst : front의 삽입 삭제 담당
		//addLLast,pollLast : rear 의 삽입 삭제
		
		
		//데트를 스택처럼 사용 가능: pop/push
		System.out.println("push 수행");
		dq.push("밤");
		dq.push("밤");
		System.out.println(dq);
		dq.pop();
		System.out.println(dq);
	
		
		
		
		
	}
}
