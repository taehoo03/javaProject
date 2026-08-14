package datastructure.queue.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {

	public static void main(String[] args) {
		// 자바 : queue 인터페이스 제공 구현 LinkedList
		// enqueue -> add,dequeue ->poll
		
		Queue<String> q	 = new LinkedList<String>();
		
		//값 추가 :add
		System.out.println("큐에 값 4개 삽입");
		q.add("홍길동");
		q.add("이몽룡");
		q.add("성춘향");
		q.offer("김털수");
		
		//Queue toString 재정의 되어 있음
		System.out.println("\n 큐 내용 출력");
		System.out.println(q);
		
		System.out.println("\n큐의 크기(저장된원소 수)"+q.size());
		System.out.println("\n 첫번째 값 : "+q.peek());
		
		
		//큐의ㅏ 원소 값 삭제 : poll,remove  : front +1원소값 삭제 
		System.out.println("\n  큐의 샂게 : "+q.poll());
		System.out.println(q);
		System.out.println("\n 큐의 삭제 : "+q.remove());
		System.out.println(q);
		
		System.out.println("\n 큐의 삭제(검색 후 삭제) : "+q.remove("김철수")); //true
		System.out.println(q);
		
		System.out.println("\n 큐의 삭제(검색 값 없을 경우) : "+q.remove("김철수")); //false
		System.out.println(q);

	}

}
